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

public class ArrayShortAccessTest {

    private short[] array;

    @Before
    public void prepareArray() {
        array = new short[100];
        for (int i = 0; i < 100; i++) {
            array[i] = (short) i;
        }
    }

    @Test
    public void getByIndex() {
        short value = ArrayMemory.getShort(array, 4);
        assertEquals(4, value);
    }

    @Test
    public void getByOffset() {
        long offset = TypeSize.ofShort() * 2 + ArrayMemory.firstElementOffset();
        short value = ArrayMemory.getShort(array, offset);
        assertEquals(2, value);
    }

    @Test
    public void getVolatileByIndex() {
        short value = ArrayMemory.getShortVolatile(array, 10);
        assertEquals(10, value);
    }

    @Test
    public void getVolatileByOffset() {
        long offset = TypeSize.ofShort() * 11 + ArrayMemory.firstElementOffset();
        short value = ArrayMemory.getShortVolatile(array, offset);
        assertEquals(11, value);
    }

    @Test
    public void setByIndex() {
        ArrayMemory.setShort(array, 7, (short) 99);
        short value = array[7];
        assertEquals(99, value);
    }

    @Test
    public void setByOffset() {
        long offset = TypeSize.ofShort() * 66 + ArrayMemory.firstElementOffset();
        ArrayMemory.setShort(array, offset, (short) 4567);
        short value = array[66];
        assertEquals(4567, value);
    }

    @Test
    public void setVolatileByIndex() {
        ArrayMemory.setShortVolatile(array, 3, (short) 88);
        short value = array[3];
        assertEquals(88, value);
    }

    @Test
    public void setVolatileByOffset() {
        long offset = TypeSize.ofShort() * 34 + ArrayMemory.firstElementOffset();
        ArrayMemory.setShortVolatile(array, offset, (short) 1234);
        short value = array[34];
        assertEquals(1234, value);
    }

}
