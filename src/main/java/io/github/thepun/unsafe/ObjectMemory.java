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
 * Allows to get internal sizes of class fields and access object data.
 *
 * Object layout:
 *  [ header ] [ field0 ] [ field1 ]  ... [ field2 ]
 *
 * All methods require fieldOffset which can be retrieved by fieldOffset and cached.
 */
@SuppressWarnings("unchecked")
public final class ObjectMemory {

    private static final Unsafe UNSAFE_INSTANCE = UnsafeLocator.getUnsafe();

    public static <T> long fieldOffset(Class<T> type, String fieldName) {
        if (type.isArray() || type.isPrimitive() || type.isInterface() || type.isEnum()) {
            throw new IllegalArgumentException("Should be class");
        }

        try {
            return UNSAFE_INSTANCE.objectFieldOffset(type.getDeclaredField(fieldName));
        } catch (Exception e) {
            throw new IllegalArgumentException("Field " + fieldName + " not found", e);
        }
    }

    public static byte getByte(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getByte(object, fieldOffset);
    }

    public static void setByte(Object object, long fieldOffset, byte newValue) {
        UNSAFE_INSTANCE.putByte(object, fieldOffset, newValue);
    }

    public static byte getByteVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getByteVolatile(object, fieldOffset);
    }

    public static void setByteVolatile(Object object, long fieldOffset, byte newValue) {
        UNSAFE_INSTANCE.putByteVolatile(object, fieldOffset, newValue);
    }

    public static short getShort(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getShort(object, fieldOffset);
    }

    public static void setShort(Object object, long fieldOffset, short newValue) {
        UNSAFE_INSTANCE.putShort(object, fieldOffset, newValue);
    }

    public static short getShortVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getShortVolatile(object, fieldOffset);
    }

    public static void setByteVolatile(Object object, long fieldOffset, short newValue) {
        UNSAFE_INSTANCE.putShortVolatile(object, fieldOffset, newValue);
    }

    public static char getChar(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getChar(object, fieldOffset);
    }

    public static void setChar(Object object, long fieldOffset, char newValue) {
        UNSAFE_INSTANCE.putChar(object, fieldOffset, newValue);
    }

    public static char getCharVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getCharVolatile(object, fieldOffset);
    }

    public static void setCharVolatile(Object object, long fieldOffset, char newValue) {
        UNSAFE_INSTANCE.putCharVolatile(object, fieldOffset, newValue);
    }


    public static char getChar(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getChar(object, fieldOffset);
    }

    public static int getInt(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getInt(object, fieldOffset);
    }

    public static float getFloat(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getFloat(object, fieldOffset);
    }

    public static long getLong(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getLong(object, fieldOffset);
    }

    public static double getDouble(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getDouble(object, fieldOffset);
    }

    public static Object getObject(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getObject(object, fieldOffset);
    }

    public static <T> T getObjectTyped(Object object, long fieldOffset) {
        return (T) getObject(object, fieldOffset);
    }

    public static void setShort(Object object, long fieldOffset, short newValue) {
        UNSAFE_INSTANCE.putShort(object, fieldOffset, newValue);
    }

    public static void setChar(Object object, long fieldOffset, char newValue) {
        UNSAFE_INSTANCE.putChar(object, fieldOffset, newValue);
    }

    public static void setInt(Object object, long fieldOffset, int newValue) {
        UNSAFE_INSTANCE.putInt(object, fieldOffset, newValue);
    }

    public static void setFloat(Object object, long fieldOffset, float newValue) {
        UNSAFE_INSTANCE.putFloat(object, fieldOffset, newValue);
    }

    public static void setLong(Object object, long fieldOffset, long newValue) {
        UNSAFE_INSTANCE.putLong(object, fieldOffset, newValue);
    }

    public static void setDouble(Object object, long fieldOffset, double newValue) {
        UNSAFE_INSTANCE.putDouble(object, fieldOffset, newValue);
    }

    public static void setObject(Object object, long fieldOffset, Object newValue) {
        UNSAFE_INSTANCE.putObject(object, fieldOffset, newValue);
    }

    public static short getShortVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getShortVolatile(object, fieldOffset);
    }

    public static char getCharVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getCharVolatile(object, fieldOffset);
    }

    public static int getIntVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getIntVolatile(object, fieldOffset);
    }

    public static float getFloatVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getFloatVolatile(object, fieldOffset);
    }

    public static long getLongVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getLongVolatile(object, fieldOffset);
    }

    public static double getDoubleVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getDoubleVolatile(object, fieldOffset);
    }

    public static Object getObjectVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getObjectVolatile(object, fieldOffset);
    }

    public static <T> T getObjectVolatileTyped(Object object, long fieldOffset) {
        return (T) getObjectVolatile(object, fieldOffset);
    }

    public static void setShortVolatile(Object object, long fieldOffset, short newValue) {
        UNSAFE_INSTANCE.putShortVolatile(object, fieldOffset, newValue);
    }

    public static void setCharVolatile(Object object, long fieldOffset, char newValue) {
        UNSAFE_INSTANCE.putCharVolatile(object, fieldOffset, newValue);
    }

    public static void setIntVolatile(Object object, long fieldOffset, int newValue) {
        UNSAFE_INSTANCE.putIntVolatile(object, fieldOffset, newValue);
    }

    public static void setFloatVolatile(Object object, long fieldOffset, float newValue) {
        UNSAFE_INSTANCE.putFloatVolatile(object, fieldOffset, newValue);
    }

    public static void setLongVolatile(Object object, long fieldOffset, long newValue) {
        UNSAFE_INSTANCE.putLongVolatile(object, fieldOffset, newValue);
    }

    public static void setDoubleVolatile(Object object, long fieldOffset, double newValue) {
        UNSAFE_INSTANCE.putDoubleVolatile(object, fieldOffset, newValue);
    }

    public static void setObjectVolatile(Object object, long fieldOffset, Object newValue) {
        UNSAFE_INSTANCE.putObjectVolatile(object, fieldOffset, newValue);
    }

    public static void setIntOrdered(Object object, long fieldOffset, int newValue) {
        UNSAFE_INSTANCE.putOrderedInt(object, fieldOffset, newValue);
    }

    public static void setLongOrdered(Object object, long fieldOffset, long newValue) {
        UNSAFE_INSTANCE.putOrderedLong(object, fieldOffset, newValue);
    }

    public static void setObjectOrdered(Object object, long fieldOffset, Object newValue) {
        UNSAFE_INSTANCE.putOrderedObject(object, fieldOffset, newValue);
    }

    public static boolean compareAndSwapInt(Object object, long fieldOffset, int expectedValue, int newValue) {
        return UNSAFE_INSTANCE.compareAndSwapInt(object, fieldOffset, expectedValue, newValue);
    }

    public static boolean compareAndSwapLong(Object object, long fieldOffset, long expectedValue, long newValue) {
        return UNSAFE_INSTANCE.compareAndSwapLong(object, fieldOffset, expectedValue, newValue);
    }

    public static boolean compareAndSwapObject(Object object, long fieldOffset, Object expectedValue, Object newValue) {
        return UNSAFE_INSTANCE.compareAndSwapObject(object, fieldOffset, expectedValue, newValue);
    }

    public static int getAndSetInt(Object object, long fieldOffset, int value) {
        return UNSAFE_INSTANCE.getAndSetInt(object, fieldOffset, value);
    }

    public static long getAndSetLong(Object object, long fieldOffset, long value) {
        return UNSAFE_INSTANCE.getAndSetLong(object, fieldOffset, value);
    }

    public static Object getAndSetObject(Object object, long fieldOffset, Object value) {
        return UNSAFE_INSTANCE.getAndSetObject(object, fieldOffset, value);
    }

    public static int getAndAddInt(Object object, long fieldOffset, int delta) {
        return UNSAFE_INSTANCE.getAndAddInt(object, fieldOffset, delta);
    }

    public static long getAndAddLong(Object object, long fieldOffset, long delta) {
        return UNSAFE_INSTANCE.getAndAddLong(object, fieldOffset, delta);
    }


    private ObjectMemory() {
    }
}
