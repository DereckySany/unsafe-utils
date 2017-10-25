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

import sun.misc.Unsafe;

/**
 * Allows to get access to raw off-heap memory.
 *
 * Memory should be allocated and freed manually.
 */
public class OffHeapMemory {

    private static final Unsafe UNSAFE_INSTANCE = UnsafeLocator.getUnsafe();
    private static final int INT_SIZE = SystemTypeSizes.intSize();
    private static final int LONG_SIZE = SystemTypeSizes.longSize();
    private static final int SHORT_SIZE = SystemTypeSizes.longSize();
    private static final int CHAR_SIZE = SystemTypeSizes.longSize();

    public static long allocate(int size) {
        return UNSAFE_INSTANCE.allocateMemory(size);
    }

    public static void free(long address) {
        UNSAFE_INSTANCE.freeMemory(address);
    }

    public static byte getByte(long address) {
        return UNSAFE_INSTANCE.getByte(address);
    }

    public static byte getByte(long address, int index) {
        return UNSAFE_INSTANCE.getByte(address + index);
    }

    public static char getChar(long address) {
        return UNSAFE_INSTANCE.getChar(address);
    }

    public static char getChar(long address, int index) {
        return UNSAFE_INSTANCE.getChar(address + index * CHAR_SIZE);
    }

    public static short getShort(long address) {
        return UNSAFE_INSTANCE.getShort(address);
    }

    public static short getShort(long address, int index) {
        return UNSAFE_INSTANCE.getShort(address + index * SHORT_SIZE);
    }

    public static int getInt(long address) {
        return UNSAFE_INSTANCE.getInt(address);
    }

    public static int getInt(long address, int index) {
        return UNSAFE_INSTANCE.getInt(address + index * INT_SIZE);
    }

    public static long getLong(long address) {
        return UNSAFE_INSTANCE.getLong(address);
    }

    public static long getLong(long address, int index) {
        return UNSAFE_INSTANCE.getLong(address + index * LONG_SIZE);
    }

    public static void setByte(long address, byte value) {
        UNSAFE_INSTANCE.putByte(address, value);
    }

    public static void setByte(long address, int index, byte value) {
        UNSAFE_INSTANCE.putByte(address + index, value);
    }

    public static void setChar(long address, char value) {
        UNSAFE_INSTANCE.putChar(address, value);
    }

    public static void setChar(long address, int index, char value) {
        UNSAFE_INSTANCE.putChar(address + index * CHAR_SIZE, value);
    }

    public static void setShort(long address, short value) {
        UNSAFE_INSTANCE.putShort(address, value);
    }

    public static void setShort(long address, int index, short value) {
        UNSAFE_INSTANCE.putShort(address + index * SHORT_SIZE, value);
    }

    public static void setInt(long address, int value) {
        UNSAFE_INSTANCE.putInt(address, value);
    }

    public static void setInt(long address, int index, int value) {
        UNSAFE_INSTANCE.putInt(address + index * 4, value);
    }

    public static void setLong(long address, long value) {
        UNSAFE_INSTANCE.putLong(address, value);
    }

    public static void setLong(long address, int index, long value) {
        UNSAFE_INSTANCE.putLong(address + index * LONG_SIZE, value);
    }


    private OffHeapMemory() {
    }
}
