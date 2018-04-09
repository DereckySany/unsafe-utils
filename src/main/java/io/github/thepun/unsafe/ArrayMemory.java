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
 * Allows to get internal offset of array structure and access its elements.
 *
 * Array layout:
 *  [ header ] [ length ] [ element0 ] ... [ elementN ]
 *
 * To get X'th element from array you with offset you have to calculate it.
 * Element offset is calculated with formula OFFSET = HEADER_SIZE + LENGTH_SIZE + INDEX * ELEMENT_SIZE or
 * OFFSET = FIRST_ELEMENT_OFFSET + INDEX * ELEMENT_SIZE
 *
 * Index is ordinary array index.
 */
@SuppressWarnings("unchecked")
public final class ArrayMemory {

    private static final Unsafe UNSAFE_INSTANCE = UnsafeLocator.getUnsafe();
    private static final long FIRST_ELEMENT_OFFSET = UNSAFE_INSTANCE.arrayBaseOffset(int[].class);

    public static long firstElementOffset() {
        return FIRST_ELEMENT_OFFSET;
    }

    public static byte getByte(byte[] array, int index) {
        return UNSAFE_INSTANCE.getByte(array, FIRST_ELEMENT_OFFSET + index);
    }

    public static void setByte(byte[] array, int index, byte element) {
        UNSAFE_INSTANCE.putByte(array, FIRST_ELEMENT_OFFSET + index, element);
    }

    public static byte getByteVolatile(byte[] array, int index) {
        return UNSAFE_INSTANCE.getByteVolatile(array, FIRST_ELEMENT_OFFSET + index);
    }

    public static void setByteVolatile(byte[] array, int index, byte element) {
        UNSAFE_INSTANCE.putByteVolatile(array, FIRST_ELEMENT_OFFSET + index, element);
    }

    public static byte getByte(byte[] array, long offset) {
        return UNSAFE_INSTANCE.getByte(array, offset);
    }

    public static void setByte(byte[] array, long offset, byte element) {
        UNSAFE_INSTANCE.putByte(array, offset, element);
    }

    public static byte getByteVolatile(byte[] array, long offset) {
        return UNSAFE_INSTANCE.getByteVolatile(array, offset);
    }

    public static void setByteVolatile(byte[] array, long offset, byte element) {
        UNSAFE_INSTANCE.putByteVolatile(array, offset, element);
    }

    public static short getShort(short[] array, int index) {
        return UNSAFE_INSTANCE.getShort(array, FIRST_ELEMENT_OFFSET + TypeSize.SHORT * index);
    }

    public static void setShort(short[] array, int index, short element) {
        UNSAFE_INSTANCE.putShort(array, FIRST_ELEMENT_OFFSET + TypeSize.SHORT * index, element);
    }

    public static short getShortVolatile(short[] array, int index) {
        return UNSAFE_INSTANCE.getShortVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.SHORT * index);
    }

    public static void setShortVolatile(short[] array, int index, short element) {
        UNSAFE_INSTANCE.putShortVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.SHORT * index, element);
    }

    public static short getShort(short[] array, long offset) {
        return UNSAFE_INSTANCE.getShort(array, offset);
    }

    public static void setShort(short[] array, long offset, short element) {
        UNSAFE_INSTANCE.putShort(array, offset, element);
    }

    public static short getShortVolatile(short[] array, long offset) {
        return UNSAFE_INSTANCE.getShortVolatile(array, offset);
    }

    public static void setShortVolatile(short[] array, long offset, short element) {
        UNSAFE_INSTANCE.putShortVolatile(array, offset, element);
    }

    public static int getInt(int[] array, int index) {
        return getInt(array, FIRST_ELEMENT_OFFSET + TypeSize.INT * index);
    }

    public static void setInt(int[] array, int index, int element) {
        setInt(array, FIRST_ELEMENT_OFFSET + TypeSize.INT * index, element);
    }

    public static int getIntVolatile(int[] array, int index) {
        return UNSAFE_INSTANCE.getIntVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.INT * index);
    }

    public static void setIntVolatile(int[] array, int index, int element) {
        UNSAFE_INSTANCE.putIntVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.INT * index, element);
    }

    public static void setIntOrdered(int[] array, int index, int element) {
        UNSAFE_INSTANCE.putOrderedInt(array, FIRST_ELEMENT_OFFSET + TypeSize.INT * index, element);
    }

    public static boolean compareAndSwapInt(int[] array, int index, int expectedElement, int newElement) {
        return UNSAFE_INSTANCE.compareAndSwapInt(array, FIRST_ELEMENT_OFFSET + TypeSize.INT * index, expectedElement, newElement);
    }

    public static int getAndSetInt(int[] array, int index, int element) {
        return UNSAFE_INSTANCE.getAndSetInt(array, FIRST_ELEMENT_OFFSET + TypeSize.INT * index, element);
    }

    public static int getAndAddInt(int[] array, int index, int element) {
        return UNSAFE_INSTANCE.getAndAddInt(array, FIRST_ELEMENT_OFFSET + TypeSize.INT * index, element);
    }

    public static int getInt(int[] array, long offset) {
        return UNSAFE_INSTANCE.getInt(array, offset);
    }

    public static void setInt(int[] array, long offset, int element) {
        UNSAFE_INSTANCE.putInt(array, offset, element);
    }

    public static int getIntVolatile(int[] array, long offset) {
        return UNSAFE_INSTANCE.getIntVolatile(array, offset);
    }

    public static void setIntVolatile(int[] array, long offset, int element) {
        UNSAFE_INSTANCE.putIntVolatile(array, offset, element);
    }

    public static void setIntOrdered(int[] array, long offset, int element) {
        UNSAFE_INSTANCE.putOrderedInt(array, offset, element);
    }

    public static boolean compareAndSwapInt(int[] array, long offset, int expectedElement, int newElement) {
        return UNSAFE_INSTANCE.compareAndSwapInt(array, offset, expectedElement, newElement);
    }

    public static int getAndSetInt(int[] array, long offset, int element) {
        return UNSAFE_INSTANCE.getAndSetInt(array, offset, element);
    }

    public static int getAndAddInt(int[] array, long offset, int element) {
        return UNSAFE_INSTANCE.getAndAddInt(array, offset, element);
    }

    public static float getFloat(float[] array, int index) {
        return UNSAFE_INSTANCE.getFloat(array, FIRST_ELEMENT_OFFSET + TypeSize.FLOAT * index);
    }

    public static void setFloat(float[] array, int index, float element) {
        UNSAFE_INSTANCE.putFloat(array, FIRST_ELEMENT_OFFSET + TypeSize.FLOAT * index, element);
    }

    public static float getFloatVolatile(float[] array, int index) {
        return UNSAFE_INSTANCE.getFloatVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.FLOAT * index);
    }

    public static void setFloatVolatile(float[] array, int index, float element) {
        UNSAFE_INSTANCE.putFloatVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.FLOAT * index, element);
    }

    public static float getFloat(float[] array, long offset) {
        return UNSAFE_INSTANCE.getFloat(array, offset);
    }

    public static void setFloat(float[] array, long offset, float element) {
        UNSAFE_INSTANCE.putFloat(array, offset, element);
    }

    public static float getFloatVolatile(float[] array, long offset) {
        return UNSAFE_INSTANCE.getFloatVolatile(array, offset);
    }

    public static void setFloatVolatile(float[] array, long offset, float element) {
        UNSAFE_INSTANCE.putFloatVolatile(array, offset, element);
    }

    public static long getLong(long[] array, int index) {
        return getLong(array, FIRST_ELEMENT_OFFSET + TypeSize.LONG * index);
    }

    public static void setLong(long[] array, int index, long element) {
        setLong(array, FIRST_ELEMENT_OFFSET + TypeSize.LONG * index, element);
    }

    public static long getLongVolatile(long[] array, int index) {
        return UNSAFE_INSTANCE.getLongVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.LONG * index);
    }

    public static void setLongVolatile(long[] array, int index, long element) {
        UNSAFE_INSTANCE.putLongVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.LONG * index, element);
    }

    public static void setLongOrdered(long[] array, int index, long element) {
        UNSAFE_INSTANCE.putOrderedLong(array, FIRST_ELEMENT_OFFSET + TypeSize.LONG * index, element);
    }

    public static boolean compareAndSwapLong(long[] array, int index, long expectedElement, long newElement) {
        return UNSAFE_INSTANCE.compareAndSwapLong(array, FIRST_ELEMENT_OFFSET + TypeSize.LONG * index, expectedElement, newElement);
    }

    public static long getAndSetLong(long[] array, int index, long element) {
        return UNSAFE_INSTANCE.getAndSetLong(array, FIRST_ELEMENT_OFFSET + TypeSize.LONG * index, element);
    }

    public static long getAndAddLong(long[] array, int index, long element) {
        return UNSAFE_INSTANCE.getAndAddLong(array, FIRST_ELEMENT_OFFSET + TypeSize.LONG * index, element);
    }

    public static long getLong(long[] array, long offset) {
        return UNSAFE_INSTANCE.getLong(array, offset);
    }

    public static void setLong(long[] array, long offset, long element) {
        UNSAFE_INSTANCE.putLong(array, offset, element);
    }

    public static long getLongVolatile(long[] array, long offset) {
        return UNSAFE_INSTANCE.getLongVolatile(array, offset);
    }

    public static void setLongVolatile(long[] array, long offset, long element) {
        UNSAFE_INSTANCE.putLongVolatile(array, offset, element);
    }

    public static void setLongOrdered(long[] array, long offset, long element) {
        UNSAFE_INSTANCE.putLongVolatile(array, offset, element);
    }

    public static boolean compareAndSwapLong(long[] array, long offset, long expectedElement, long newElement) {
        return UNSAFE_INSTANCE.compareAndSwapLong(array, offset, expectedElement, newElement);
    }

    public static long getAndSetLong(long[] array, long offset, long element) {
        return UNSAFE_INSTANCE.getAndSetLong(array, offset, element);
    }

    public static long getAndAddLong(long[] array, long offset, long element) {
        return UNSAFE_INSTANCE.getAndAddLong(array, offset, element);
    }

    public static double getDouble(double[] array, int index) {
        return UNSAFE_INSTANCE.getDouble(array, FIRST_ELEMENT_OFFSET + TypeSize.DOUBLE * index);
    }

    public static void setDouble(double[] array, int index, double element) {
        UNSAFE_INSTANCE.putDouble(array, FIRST_ELEMENT_OFFSET + TypeSize.DOUBLE * index, element);
    }

    public static double getDoubleVolatile(double[] array, int index) {
        return UNSAFE_INSTANCE.getDoubleVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.DOUBLE * index);
    }

    public static void setDoubleVolatile(double[] array, int index, double element) {
        UNSAFE_INSTANCE.putDoubleVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.DOUBLE * index, element);
    }

    public static double getDouble(double[] array, long offset) {
        return UNSAFE_INSTANCE.getDouble(array, offset);
    }

    public static void setDouble(double[] array, long offset, double element) {
        UNSAFE_INSTANCE.putDouble(array, offset, element);
    }

    public static double getDoubleVolatile(double[] array, long offset) {
        return UNSAFE_INSTANCE.getDoubleVolatile(array, offset);
    }

    public static void setDoubleVolatile(double[] array, long offset, double element) {
        UNSAFE_INSTANCE.putDoubleVolatile(array, offset, element);
    }

    public static <T> T getObject(T[] array, int index) {
        return getObject(array, FIRST_ELEMENT_OFFSET + TypeSize.REFERENCE_ * index);
    }

    public static <T> void setObject(T[] array, int index, T element) {
        setObject(array, FIRST_ELEMENT_OFFSET + TypeSize.REFERENCE_ * index, element);
    }

    public static <T> Object getObjectVolatile(T[] array, int index) {
        return UNSAFE_INSTANCE.getObjectVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.REFERENCE_ * index);
    }

    public static <T> void setObjectVolatile(T[] array, int index, T element) {
        UNSAFE_INSTANCE.putObjectVolatile(array, FIRST_ELEMENT_OFFSET + TypeSize.REFERENCE_ * index, element);
    }

    public static <T> void setObjectOrdered(T[] array, int index, T element) {
        UNSAFE_INSTANCE.putOrderedObject(array, FIRST_ELEMENT_OFFSET + TypeSize.REFERENCE_ * index, element);
    }

    public static <T> boolean compareAndSwapObject(T[] array, int index, T expectedElement, T newElement) {
        return UNSAFE_INSTANCE.compareAndSwapObject(array, FIRST_ELEMENT_OFFSET + TypeSize.REFERENCE_ * index, expectedElement, newElement);
    }

    public static <T> T getAndSetObject(T[] array, int index, T element) {
        return (T) UNSAFE_INSTANCE.getAndSetObject(array, FIRST_ELEMENT_OFFSET + TypeSize.REFERENCE_ * index, element);
    }

    public static <T> T getObject(T[] array, long offset) {
        return (T) UNSAFE_INSTANCE.getObject(array, offset);
    }

    public static <T> void setObject(T[] array, long offset, T element) {
        UNSAFE_INSTANCE.putObject(array, offset, element);
    }

    public static <T> Object getObjectVolatile(T[] array, long offset) {
        return UNSAFE_INSTANCE.getObjectVolatile(array, offset);
    }

    public static <T> void setObjectVolatile(T[] array, long offset, T element) {
        UNSAFE_INSTANCE.putObjectVolatile(array, offset, element);
    }

    public static <T> void setObjectOrdered(T[] array, long offset, T element) {
        UNSAFE_INSTANCE.putObjectVolatile(array, offset, element);
    }

    public static <T> boolean compareAndSwapObject(T[] array, long offset, T expectedElement, T newElement) {
        return UNSAFE_INSTANCE.compareAndSwapObject(array, offset, expectedElement, newElement);
    }

    public static <T> T getAndSetObject(T[] array, long offset, T element) {
        return (T) UNSAFE_INSTANCE.getAndSetObject(array, offset, element);
    }


    private ArrayMemory() {
    }
}
