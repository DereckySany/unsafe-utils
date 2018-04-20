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

public class ArrayByteAccessTest {

    private byte[] array;

    @Before
    public void prepareArray() {
        array = new byte[100];
        for (int i = 0; i < 100; i++) {
            array[i] = (byte) i;
        }
    }

    @Test
    public void getByIndex() {
        byte value = ArrayMemory.getByte(array, 4);
        assertEquals(4, value);
    }

    @Test
    public void getByOffset() {
        long offset = 2 + ArrayMemory.firstElementOffset();
        byte value = ArrayMemory.getByte(array, offset);
        assertEquals(2, value);
    }

    @Test
    public void getVolatileByIndex() {
        byte value = ArrayMemory.getByteVolatile(array, 10);
        assertEquals(10, value);
    }

    @Test
    public void getVolatileByOffset() {
        long offset = 11 + ArrayMemory.firstElementOffset();
        byte value = ArrayMemory.getByteVolatile(array, offset);
        assertEquals(11, value);
    }

    @Test
    public void setByIndex() {
        ArrayMemory.setByte(array, 7, (byte) 99);
        byte value = array[7];
        assertEquals(99, value);
    }

    @Test
    public void setByOffset() {
        long offset = 66 + ArrayMemory.firstElementOffset();
        ArrayMemory.setByte(array, offset, (byte) 123);
        byte value = array[66];
        assertEquals(123, value);
    }

    @Test
    public void setVolatileByIndex() {
        ArrayMemory.setByteVolatile(array, 3, (byte) 88);
        byte value = array[3];
        assertEquals(88, value);
    }

    @Test
    public void setVolatileByOffset() {
        long offset = 34 + ArrayMemory.firstElementOffset();
        ArrayMemory.setByteVolatile(array, offset, (byte) 33);
        byte value = array[34];
        assertEquals(33, value);
    }
}
