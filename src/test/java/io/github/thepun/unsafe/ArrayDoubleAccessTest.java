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

import static org.junit.Assert.assertEquals;

public class ArrayDoubleAccessTest {

    private double[] array;

    @Before
    public void prepareArray() {
        array = new double[100];
        for (int i = 0; i < 100; i++) {
            array[i] = (double) i;
        }
    }

    @Test
    public void getByIndex() {
        double value = ArrayMemory.getDouble(array, 44);
        assertEquals(44, value, 0.0001);
    }

    @Test
    public void getByOffset() {
        long offset = TypeSize.ofDouble() * 2 + ArrayMemory.firstElementOffset();
        double value = ArrayMemory.getDouble(array, offset);
        assertEquals(2, value, 0.0001);
    }

    @Test
    public void getVolatileByIndex() {
        double value = ArrayMemory.getDoubleVolatile(array, 15);
        assertEquals(15, value, 0.0001);
    }

    @Test
    public void getVolatileByOffset() {
        long offset = TypeSize.ofDouble() * 16 + ArrayMemory.firstElementOffset();
        double value = ArrayMemory.getDoubleVolatile(array, offset);
        assertEquals(16, value, 0.0001);
    }

    @Test
    public void setByIndex() {
        ArrayMemory.setDouble(array, 77, 9923.);
        double value = array[77];
        assertEquals(9923, value, 0.0001);
    }

    @Test
    public void setByOffset() {
        long offset = TypeSize.ofDouble() * 6 + ArrayMemory.firstElementOffset();
        ArrayMemory.setDouble(array, offset, 456721.);
        double value = array[6];
        assertEquals(456721., value, 0.0001);
    }

    @Test
    public void setVolatileByIndex() {
        ArrayMemory.setDoubleVolatile(array, 37, 8812.);
        double value = array[37];
        assertEquals(8812, value, 0.0001);
    }

    @Test
    public void setVolatileByOffset() {
        long offset = TypeSize.ofDouble() * 34 + ArrayMemory.firstElementOffset();
        ArrayMemory.setDoubleVolatile(array, offset, 123456.);
        double value = array[34];
        assertEquals(123456, value, 0.0001);
    }

}
