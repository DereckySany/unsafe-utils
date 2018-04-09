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

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OffHeapArrayCopyToTest {

    @Test
    public void copyBytes() {
        long address = OffHeapMemory.allocate(10);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setByte(address + i, (byte) (i * 4));
        }

        byte[] bytes = new byte[10];
        OffHeapMemory.copyToArray(address, bytes);

        for (int i = 0; i < bytes.length; i++) {
            assertEquals(i * 4, bytes[i]);
        }
    }

    @Test
    public void copyBytesWithOffset() {
        long address = OffHeapMemory.allocate(10);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setByte(address + i, (byte) (i * 3));
        }

        byte[] bytes = new byte[10];
        OffHeapMemory.copyToArray(address, bytes, 3, 4);

        for (int i = 0; i < 3; i++) {
            assertEquals(0, bytes[i]);
        }
        for (int i = 3; i < 7; i++) {
            assertEquals((i - 3) * 3, bytes[i]);
        }
        for (int i = 7; i < 10; i++) {
            assertEquals(0, bytes[i]);
        }
    }

    @Test
    public void copyChars() {
        long address = OffHeapMemory.allocate(10);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setChar(address + TypeSize.CHAR * i, (char) (i * 4));
        }

        char[] chars = new char[10];
        OffHeapMemory.copyToArray(address, chars);

        for (int i = 0; i < chars.length; i++) {
            assertEquals(i * 4, chars[i]);
        }
    }

    @Test
    public void copySCharsWithOffset() {
        long address = OffHeapMemory.allocate(10 * TypeSize.CHAR);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setChar(address + i * TypeSize.CHAR, (char) (i * 3));
        }

        char[] chars = new char[10];
        OffHeapMemory.copyToArray(address, chars, 3, 4);

        for (int i = 0; i < 3; i++) {
            assertEquals(0, chars[i]);
        }
        for (int i = 3; i < 7; i++) {
            assertEquals((i - 3) * 3, chars[i]);
        }
        for (int i = 7; i < 10; i++) {
            assertEquals(0, chars[i]);
        }
    }

    @Test
    public void copyShorts() {
        long address = OffHeapMemory.allocate(10 * TypeSize.SHORT);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setShort(address + i * TypeSize.SHORT, (short) (i * 7));
        }

        short[] shorts = new short[10];
        OffHeapMemory.copyToArray(address, shorts);

        for (int i = 0; i < shorts.length; i++) {
            assertEquals(i * 7, shorts[i]);
        }
    }

    @Test
    public void copyShortsWithOffset() {
        long address = OffHeapMemory.allocate(10 * TypeSize.SHORT);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setShort(address + i * TypeSize.SHORT, (short) (i * 3));
        }

        short[] shorts = new short[10];
        OffHeapMemory.copyToArray(address, shorts, 3, 4);

        for (int i = 0; i < 3; i++) {
            assertEquals(0, shorts[i]);
        }
        for (int i = 3; i < 7; i++) {
            assertEquals((i - 3) * 3, shorts[i]);
        }
        for (int i = 7; i < 10; i++) {
            assertEquals(0, shorts[i]);
        }
    }

    @Test
    public void copyInts() {
        long address = OffHeapMemory.allocate(10 * TypeSize.INT);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setInt(address + i * TypeSize.INT, (i * 7));
        }

        int[] ints = new int[10];
        OffHeapMemory.copyToArray(address, ints);

        for (int i = 0; i < ints.length; i++) {
            assertEquals(i * 7, ints[i]);
        }
    }

    @Test
    public void copyIntsWithOffset() {
        long address = OffHeapMemory.allocate(10 * TypeSize.INT);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setInt(address + i * TypeSize.INT, (i * 3));
        }

        int[] ints = new int[10];
        OffHeapMemory.copyToArray(address, ints, 3, 4);

        for (int i = 0; i < 3; i++) {
            assertEquals(0, ints[i]);
        }
        for (int i = 3; i < 7; i++) {
            assertEquals((i - 3) * 3, ints[i]);
        }
        for (int i = 7; i < 10; i++) {
            assertEquals(0, ints[i]);
        }
    }

    @Test
    public void copyLongs() {
        long address = OffHeapMemory.allocate(10 * TypeSize.LONG);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setLong(address + i * TypeSize.LONG, (i * 7));
        }

        long[] longs = new long[10];
        OffHeapMemory.copyToArray(address, longs);

        for (int i = 0; i < longs.length; i++) {
            assertEquals(i * 7, longs[i]);
        }
    }

    @Test
    public void copyLongsWithOffset() {
        long address = OffHeapMemory.allocate(10 * TypeSize.LONG);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setLong(address + i * TypeSize.LONG, (i * 3));
        }

        long[] longs = new long[10];
        OffHeapMemory.copyToArray(address, longs, 3, 4);

        for (int i = 0; i < 3; i++) {
            assertEquals(0, longs[i]);
        }
        for (int i = 3; i < 7; i++) {
            assertEquals((i - 3) * 3, longs[i]);
        }
        for (int i = 7; i < 10; i++) {
            assertEquals(0, longs[i]);
        }
    }

    @Test
    public void copyFloats() {
        long address = OffHeapMemory.allocate(10 * TypeSize.FLOAT);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setFloat(address + i * TypeSize.FLOAT, i * 7f / 3.33f);
        }

        float[] floats = new float[10];
        OffHeapMemory.copyToArray(address, floats);

        for (int i = 0; i < floats.length; i++) {
            assertEquals(i * 7f / 3.33f, floats[i], 0.00001);
        }
    }

    @Test
    public void copyFloatsWithOffset() {
        long address = OffHeapMemory.allocate(10 * TypeSize.FLOAT);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setFloat(address + i * TypeSize.FLOAT, (i * 3));
        }

        float[] floats = new float[10];
        OffHeapMemory.copyToArray(address, floats, 3, 4);

        for (int i = 0; i < 3; i++) {
            assertEquals(0, floats[i], 0.00001);
        }
        for (int i = 3; i < 7; i++) {
            assertEquals((i - 3) * 3, floats[i], 0.00001);
        }
        for (int i = 7; i < 10; i++) {
            assertEquals(0, floats[i], 0.00001);
        }
    }

    @Test
    public void copyDoubles() {
        long address = OffHeapMemory.allocate(10 * TypeSize.DOUBLE);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setDouble(address + i * TypeSize.DOUBLE, i * 7f / 3.33f);
        }

        double[] doubles = new double[10];
        OffHeapMemory.copyToArray(address, doubles);

        for (int i = 0; i < doubles.length; i++) {
            assertEquals(i * 7f / 3.33f, doubles[i], 0.00001);
        }
    }

    @Test
    public void copyDoublesWithOffset() {
        long address = OffHeapMemory.allocate(10 * TypeSize.DOUBLE);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setDouble(address + i * TypeSize.DOUBLE, (i * 3));
        }

        double[] doubles = new double[10];
        OffHeapMemory.copyToArray(address, doubles, 3, 4);

        for (int i = 0; i < 3; i++) {
            assertEquals(0, doubles[i], 0.00001);
        }
        for (int i = 3; i < 7; i++) {
            assertEquals((i - 3) * 3, doubles[i], 0.00001);
        }
        for (int i = 7; i < 10; i++) {
            assertEquals(0, doubles[i], 0.00001);
        }
    }
}
