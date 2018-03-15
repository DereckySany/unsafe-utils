/**
 * Copyright (C)2011 - Marat Gariev <thepun599@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.thepun.unsafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayObjectTest {

    private Object[] array;

    @Before
    public void prepareArray() {
        array = new Object[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i;
        }
    }

    @Test
    public void getByIndex() {
        Object value = ArrayMemory.getObject(array, 4);
        assertEquals(4, value);
    }

    @Test
    public void getByOffset() {
        long offset = TypeSize.ofReference() * 2 + ArrayMemory.firstElementOffset();
        Object value = ArrayMemory.getObject(array, offset);
        assertEquals(2, value);
    }

    @Test
    public void getVolatileByIndex() {
        Object value = ArrayMemory.getObjectVolatile(array, 10);
        assertEquals(10, value);
    }

    @Test
    public void getVolatileByOffset() {
        long offset = TypeSize.ofReference() * 11 + ArrayMemory.firstElementOffset();
        Object value = ArrayMemory.getObjectVolatile(array, offset);
        assertEquals(11, value);
    }

    @Test
    public void setByIndex() {
        ArrayMemory.setObject(array, 7, 99);
        Object value = array[7];
        assertEquals(99, value);
    }

    @Test
    public void setByOffset() {
        long offset = TypeSize.ofReference() * 66 + ArrayMemory.firstElementOffset();
        ArrayMemory.setObject(array, offset, 4567);
        Object value = array[66];
        assertEquals(4567, value);
    }

    @Test
    public void setVolatileByIndex() {
        ArrayMemory.setObjectVolatile(array, 3, 88);
        Object value = array[3];
        assertEquals(88, value);
    }

    @Test
    public void setVolatileByOffset() {
        long offset = TypeSize.ofReference() * 34 + ArrayMemory.firstElementOffset();
        ArrayMemory.setObjectVolatile(array, offset, 1234);
        Object value = array[34];
        assertEquals(1234, value);
    }

    @Test
    public void setOrderedByIndex() {
        ArrayMemory.setObjectOrdered(array, 5, 23);
        Object value = array[5];
        assertEquals(23, value);
    }

    @Test
    public void setOrderedByOffset() {
        long offset = TypeSize.ofReference() * 55 + ArrayMemory.firstElementOffset();
        ArrayMemory.setObjectOrdered(array, offset, 87);
        Object value = array[55];
        assertEquals(87, value);
    }

    @Test
    public void casSuccessByIndex() {
        boolean cas = ArrayMemory.compareAndSwapObject(array, 75, 75, 99);
        assertTrue(cas);

        Object value = array[75];
        assertEquals(99, value);
    }

    @Test
    public void casSuccessByOffset() {
        long offset = TypeSize.ofReference() * 91 + ArrayMemory.firstElementOffset();
        boolean cas = ArrayMemory.compareAndSwapObject(array, offset, 91, 2);
        assertTrue(cas);

        Object value = array[91];
        assertEquals(2, value);
    }

    @Test
    public void casFailureByIndex() {
        boolean cas = ArrayMemory.compareAndSwapObject(array, 55, 54, 123);
        assertFalse(cas);

        Object value = array[55];
        assertEquals(55, value);
    }

    @Test
    public void casFailureByOffset() {
        long offset = TypeSize.ofReference() * 43 + ArrayMemory.firstElementOffset();
        boolean cas = ArrayMemory.compareAndSwapObject(array, offset, 77, 456);
        assertFalse(cas);

        Object value = array[43];
        assertEquals(43, value);
    }

}
