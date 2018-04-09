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

public class ArrayLongAccessTest {

    private long[] array;

    @Before
    public void prepareArray() {
        array = new long[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i;
        }
    }

    @Test
    public void getByIndex() {
        long value = ArrayMemory.getLong(array, 4);
        assertEquals(4, value);
    }

    @Test
    public void getByOffset() {
        long offset = TypeSize.LONG * 2 + ArrayMemory.firstElementOffset();
        long value = ArrayMemory.getLong(array, offset);
        assertEquals(2, value);
    }

    @Test
    public void getVolatileByIndex() {
        long value = ArrayMemory.getLongVolatile(array, 10);
        assertEquals(10, value);
    }

    @Test
    public void getVolatileByOffset() {
        long offset = TypeSize.LONG * 11 + ArrayMemory.firstElementOffset();
        long value = ArrayMemory.getLongVolatile(array, offset);
        assertEquals(11, value);
    }

    @Test
    public void setByIndex() {
        ArrayMemory.setLong(array, 7, 99);
        long value = array[7];
        assertEquals(99, value);
    }

    @Test
    public void setByOffset() {
        long offset = TypeSize.LONG * 66 + ArrayMemory.firstElementOffset();
        ArrayMemory.setLong(array, offset, 4567);
        long value = array[66];
        assertEquals(4567, value);
    }

    @Test
    public void setVolatileByIndex() {
        ArrayMemory.setLongVolatile(array, 3, 88);
        long value = array[3];
        assertEquals(88, value);
    }

    @Test
    public void setVolatileByOffset() {
        long offset = TypeSize.LONG * 34 + ArrayMemory.firstElementOffset();
        ArrayMemory.setLongVolatile(array, offset, 1234);
        long value = array[34];
        assertEquals(1234, value);
    }

    @Test
    public void setOrderedByIndex() {
        ArrayMemory.setLongOrdered(array, 5, 23);
        long value = array[5];
        assertEquals(23, value);
    }

    @Test
    public void setOrderedByOffset() {
        long offset = TypeSize.LONG * 55 + ArrayMemory.firstElementOffset();
        ArrayMemory.setLongOrdered(array, offset, 87);
        long value = array[55];
        assertEquals(87, value);
    }

    @Test
    public void casSuccessByIndex() {
        boolean cas = ArrayMemory.compareAndSwapLong(array, 75, 75, 99);
        assertTrue(cas);

        long value = array[75];
        assertEquals(99, value);
    }

    @Test
    public void casSuccessByOffset() {
        long offset = TypeSize.LONG * 91 + ArrayMemory.firstElementOffset();
        boolean cas = ArrayMemory.compareAndSwapLong(array, offset, 91, 2);
        assertTrue(cas);

        long value = array[91];
        assertEquals(2, value);
    }

    @Test
    public void casFailureByIndex() {
        boolean cas = ArrayMemory.compareAndSwapLong(array, 55, 54, 123);
        assertFalse(cas);

        long value = array[55];
        assertEquals(55, value);
    }

    @Test
    public void casFailureByOffset() {
        long offset = TypeSize.LONG * 43 + ArrayMemory.firstElementOffset();
        boolean cas = ArrayMemory.compareAndSwapLong(array, offset, 77, 456);
        assertFalse(cas);

        long value = array[43];
        assertEquals(43, value);
    }

}
