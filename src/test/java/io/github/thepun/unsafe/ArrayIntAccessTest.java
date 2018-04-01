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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayIntAccessTest {

    private int[] array;

    @Before
    public void prepareArray() {
        array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i;
        }
    }

    @Test
    public void getByIndex() {
        int value = ArrayMemory.getInt(array, 4);
        assertEquals(4, value);
    }

    @Test
    public void getByOffset() {
        long offset = TypeSize.ofInt() * 2 + ArrayMemory.firstElementOffset();
        int value = ArrayMemory.getInt(array, offset);
        assertEquals(2, value);
    }

    @Test
    public void getVolatileByIndex() {
        int value = ArrayMemory.getIntVolatile(array, 10);
        assertEquals(10, value);
    }

    @Test
    public void getVolatileByOffset() {
        long offset = TypeSize.ofInt() * 11 + ArrayMemory.firstElementOffset();
        int value = ArrayMemory.getIntVolatile(array, offset);
        assertEquals(11, value);
    }

    @Test
    public void setByIndex() {
        ArrayMemory.setInt(array, 7, 99);
        int value = array[7];
        assertEquals(99, value);
    }

    @Test
    public void setByOffset() {
        long offset = TypeSize.ofInt() * 66 + ArrayMemory.firstElementOffset();
        ArrayMemory.setInt(array, offset, 4567);
        int value = array[66];
        assertEquals(4567, value);
    }

    @Test
    public void setVolatileByIndex() {
        ArrayMemory.setIntVolatile(array, 3, 88);
        int value = array[3];
        assertEquals(88, value);
    }

    @Test
    public void setVolatileByOffset() {
        long offset = TypeSize.ofInt() * 34 + ArrayMemory.firstElementOffset();
        ArrayMemory.setIntVolatile(array, offset, 1234);
        int value = array[34];
        assertEquals(1234, value);
    }

    @Test
    public void setOrderedByIndex() {
        ArrayMemory.setIntOrdered(array, 5, 23);
        int value = array[5];
        assertEquals(23, value);
    }

    @Test
    public void setOrderedByOffset() {
        long offset = TypeSize.ofInt() * 55 + ArrayMemory.firstElementOffset();
        ArrayMemory.setIntOrdered(array, offset, 87);
        int value = array[55];
        assertEquals(87, value);
    }

    @Test
    public void casSuccessByIndex() {
        boolean cas = ArrayMemory.compareAndSwapInt(array, 75, 75, 99);
        assertTrue(cas);

        int value = array[75];
        assertEquals(99, value);
    }

    @Test
    public void casSuccessByOffset() {
        long offset = TypeSize.ofInt() * 91 + ArrayMemory.firstElementOffset();
        boolean cas = ArrayMemory.compareAndSwapInt(array, offset, 91, 2);
        assertTrue(cas);

        int value = array[91];
        assertEquals(2, value);
    }

    @Test
    public void casFailureByIndex() {
        boolean cas = ArrayMemory.compareAndSwapInt(array, 55, 54, 123);
        assertFalse(cas);

        int value = array[55];
        assertEquals(55, value);
    }

    @Test
    public void casFailureByOffset() {
        long offset = TypeSize.ofInt() * 43 + ArrayMemory.firstElementOffset();
        boolean cas = ArrayMemory.compareAndSwapInt(array, offset, 77, 456);
        assertFalse(cas);

        int value = array[43];
        assertEquals(43, value);
    }

}
