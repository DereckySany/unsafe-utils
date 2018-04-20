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

public class ArrayFloatAccessTest {

    private float[] array;

    @Before
    public void prepareArray() {
        array = new float[100];
        for (int i = 0; i < 100; i++) {
            array[i] = (float) i;
        }
    }

    @Test
    public void getByIndex() {
        float value = ArrayMemory.getFloat(array, 4);
        assertEquals(4, value, 0.0001);
    }

    @Test
    public void getByOffset() {
        long offset = TypeSize.FLOAT * 2 + ArrayMemory.firstElementOffset();
        float value = ArrayMemory.getFloat(array, offset);
        assertEquals(2, value, 0.0001);
    }

    @Test
    public void getVolatileByIndex() {
        float value = ArrayMemory.getFloatVolatile(array, 10);
        assertEquals(10, value, 0.0001);
    }

    @Test
    public void getVolatileByOffset() {
        long offset = TypeSize.FLOAT * 11 + ArrayMemory.firstElementOffset();
        float value = ArrayMemory.getFloatVolatile(array, offset);
        assertEquals(11, value, 0.0001);
    }

    @Test
    public void setByIndex() {
        ArrayMemory.setFloat(array, 7, (float) 992);
        float value = array[7];
        assertEquals(992, value, 0.0001);
    }

    @Test
    public void setByOffset() {
        long offset = TypeSize.FLOAT * 66 + ArrayMemory.firstElementOffset();
        ArrayMemory.setFloat(array, offset, (float) 45672);
        float value = array[66];
        assertEquals(45672, value, 0.0001);
    }

    @Test
    public void setVolatileByIndex() {
        ArrayMemory.setFloatVolatile(array, 3, (float) 881.);
        float value = array[3];
        assertEquals(881, value, 0.0001);
    }

    @Test
    public void setVolatileByOffset() {
        long offset = TypeSize.FLOAT * 34 + ArrayMemory.firstElementOffset();
        ArrayMemory.setFloatVolatile(array, offset, (float) 12345);
        float value = array[34];
        assertEquals(12345, value, 0.0001);
    }

}
