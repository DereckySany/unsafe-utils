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

public class OffHeapAccessTest {

    @Test
    public void getAndSetByteByOffset() {
        long address = OffHeapMemory.allocate(100);
        long offset = 10;
        OffHeapMemory.setByte(address + offset, (byte) 33);

        byte value = OffHeapMemory.getByte(address + offset);
        assertEquals(33, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetIntByOffset() {
        long address = OffHeapMemory.allocate(100 * TypeSize.ofInt());
        long offset = TypeSize.ofInt() * 10;
        OffHeapMemory.setInt(address + offset, 123);

        int value = OffHeapMemory.getInt(address + offset);
        assertEquals(123, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetShortByOffset() {
        long address = OffHeapMemory.allocate(100 * TypeSize.ofShort());
        long offset = TypeSize.ofShort() * 54;
        OffHeapMemory.setShort(address + offset, (short) 12323);

        short value = OffHeapMemory.getShort(address + offset);
        assertEquals(12323, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetCharByOffset() {
        long address = OffHeapMemory.allocate(100 * TypeSize.ofChar());
        long offset = TypeSize.ofShort() * 71;
        OffHeapMemory.setChar(address + offset, 'a');

        char value = OffHeapMemory.getChar(address + offset);
        assertEquals('a', value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetFloatByOffset() {
        long address = OffHeapMemory.allocate(100 * TypeSize.ofFloat());
        long offset = TypeSize.ofFloat() * 67;
        OffHeapMemory.setFloat(address + offset, 1.23456789f);

        float value = OffHeapMemory.getFloat(address + offset);
        assertEquals(1.23456789f, value, 0.000000001);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetLongByOffset() {
        long address = OffHeapMemory.allocate(100 * TypeSize.ofLong());
        long offset = TypeSize.ofLong() * 67;
        OffHeapMemory.setLong(address + offset, 354673567L);

        long value = OffHeapMemory.getLong(address + offset);
        assertEquals(354673567L, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetDoubleByOffset() {
        long address = OffHeapMemory.allocate(100 * TypeSize.ofDouble());
        long offset = TypeSize.ofDouble() * 54;
        OffHeapMemory.setDouble(address + offset, 0.2468d);

        double value = OffHeapMemory.getDouble(address + offset);
        assertEquals(0.2468d, value, 0.00001d);

        OffHeapMemory.free(address);
    }
}
