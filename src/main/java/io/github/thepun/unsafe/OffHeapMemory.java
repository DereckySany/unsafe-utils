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
public final class OffHeapMemory {

    private static final Unsafe UNSAFE_INSTANCE = UnsafeLocator.getUnsafe();

    public static long allocate(int size) {
        return UNSAFE_INSTANCE.allocateMemory(size);
    }

    public static void free(long address) {
        UNSAFE_INSTANCE.freeMemory(address);
    }

    public static byte getByte(long address) {
        return UNSAFE_INSTANCE.getByte(address);
    }

    public static char getChar(long address) {
        return UNSAFE_INSTANCE.getChar(address);
    }

    public static short getShort(long address) {
        return UNSAFE_INSTANCE.getShort(address);
    }

    public static int getInt(long address) {
        return UNSAFE_INSTANCE.getInt(address);
    }

    public static float getFloat(long address) {
        return UNSAFE_INSTANCE.getFloat(address);
    }

    public static long getLong(long address) {
        return UNSAFE_INSTANCE.getLong(address);
    }

    public static double getDouble(long address) {
        return UNSAFE_INSTANCE.getDouble(address);
    }

    public static void setByte(long address, byte value) {
        UNSAFE_INSTANCE.putByte(address, value);
    }

    public static void setChar(long address, char value) {
        UNSAFE_INSTANCE.putChar(address, value);
    }

    public static void setShort(long address, short value) {
        UNSAFE_INSTANCE.putShort(address, value);
    }

    public static void setInt(long address, int value) {
        UNSAFE_INSTANCE.putInt(address, value);
    }

    public static void setFloat(long address, float value) {
        UNSAFE_INSTANCE.putFloat(address, value);
    }

    public static void setLong(long address, long value) {
        UNSAFE_INSTANCE.putLong(address, value);
    }

    public static void setDouble(long address, double value) {
        UNSAFE_INSTANCE.putDouble(address, value);
    }

    public static void copy(long addressFrom, long addressTo, int length) {
        UNSAFE_INSTANCE.copyMemory(addressFrom, addressTo, length);
    }

    public static void copyToArray(long address, byte[] array) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset(), array.length);
    }

    public static void copyToArray(long address, byte[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset() + offset, length);
    }

    public static void copyToArray(long address, char[] array) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset(), array.length * TypeSize.CHAR);
    }

    public static void copyToArray(long address, char[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset() + offset * TypeSize.CHAR, length * TypeSize.CHAR);
    }

    public static void copyToArray(long address, short[] array) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset(), array.length * TypeSize.SHORT);
    }

    public static void copyToArray(long address, short[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset() + offset * TypeSize.SHORT, length * TypeSize.SHORT);
    }

    public static void copyToArray(long address, int[] array) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset(), array.length * TypeSize.INT);
    }

    public static void copyToArray(long address, int[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset() + offset * TypeSize.INT, length * TypeSize.INT);
    }

    public static void copyToArray(long address, float[] array) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset(), array.length * TypeSize.FLOAT);
    }

    public static void copyToArray(long address, float[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset() + offset * TypeSize.FLOAT, length * TypeSize.FLOAT);
    }

    public static void copyToArray(long address, long[] array) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset(), array.length * TypeSize.LONG);
    }

    public static void copyToArray(long address, long[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset() + offset * TypeSize.LONG, length * TypeSize.LONG);
    }

    public static void copyToArray(long address, double[] array) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset(), array.length * TypeSize.DOUBLE);
    }

    public static void copyToArray(long address, double[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(null, address, array, ArrayMemory.firstElementOffset() + offset * TypeSize.DOUBLE, length * TypeSize.DOUBLE);
    }

    public static void copyFromArray(long address, byte[] array) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset(), null, address, array.length);
    }

    public static void copyFromArray(long address, byte[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset() + offset, null, address, length);
    }

    public static void copyFromArray(long address, char[] array) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset(), null, address, array.length * TypeSize.CHAR);
    }

    public static void copyFromArray(long address, char[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset() + offset * TypeSize.CHAR, null, address, length * TypeSize.CHAR);
    }

    public static void copyFromArray(long address, short[] array) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset(), null, address, array.length * TypeSize.SHORT);
    }

    public static void copyFromArray(long address, short[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset() + offset * TypeSize.SHORT, null, address, length * TypeSize.SHORT);
    }

    public static void copyFromArray(long address, int[] array) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset(), null, address, array.length * TypeSize.INT);
    }

    public static void copyFromArray(long address, int[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset() + offset * TypeSize.INT, null, address, length * TypeSize.INT);
    }

    public static void copyFromArray(long address, float[] array) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset(), null, address, array.length * TypeSize.FLOAT);
    }

    public static void copyFromArray(long address, float[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset() + offset * TypeSize.FLOAT, null, address, length * TypeSize.FLOAT);
    }

    public static void copyFromArray(long address, long[] array) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset(), null, address, array.length * TypeSize.LONG);
    }

    public static void copyFromArray(long address, long[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset() + offset * TypeSize.LONG, null, address, length * TypeSize.LONG);
    }

    public static void copyFromArray(long address, double[] array) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset(), null, address, array.length * TypeSize.DOUBLE);
    }

    public static void copyFromArray(long address, double[] array, int offset, int length) {
        UNSAFE_INSTANCE.copyMemory(array, ArrayMemory.firstElementOffset() + offset * TypeSize.DOUBLE, null, address, length * TypeSize.DOUBLE);
    }

    private OffHeapMemory() {
    }
}
