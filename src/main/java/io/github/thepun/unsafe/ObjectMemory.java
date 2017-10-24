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
public class ObjectMemory {

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

    public static int getInt(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getInt(object, fieldOffset);
    }

    public static long getLong(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getLong(object, fieldOffset);
    }

    public static Object getObject(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getObject(object, fieldOffset);
    }

    public static void setInt(Object object, long fieldOffset, int newValue) {
        UNSAFE_INSTANCE.putInt(object, fieldOffset, newValue);
    }

    public static void setLong(Object object, long fieldOffset, long newValue) {
        UNSAFE_INSTANCE.putLong(object, fieldOffset, newValue);
    }

    public static void setObject(Object object, long fieldOffset, Object newValue) {
        UNSAFE_INSTANCE.putObject(object, fieldOffset, newValue);
    }

    public static int getIntVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getIntVolatile(object, fieldOffset);
    }

    public static long getLongVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getLongVolatile(object, fieldOffset);
    }

    public static Object getObjectVolatile(Object object, long fieldOffset) {
        return UNSAFE_INSTANCE.getObjectVolatile(object, fieldOffset);
    }

    public static void setIntVolatile(Object object, long fieldOffset, int newValue) {
        UNSAFE_INSTANCE.putIntVolatile(object, fieldOffset, newValue);
    }

    public static void setLongVolatile(Object object, long fieldOffset, long newValue) {
        UNSAFE_INSTANCE.putLongVolatile(object, fieldOffset, newValue);
    }

    public static void setObjectVolatile(Object object, long fieldOffset, Object newValue) {
        UNSAFE_INSTANCE.putObjectVolatile(object, fieldOffset, newValue);
    }

    public static void setIntOrdered(Object object, long fieldOffset, int newValue) {
        UNSAFE_INSTANCE.putIntVolatile(object, fieldOffset, newValue);
    }

    public static void setLongOrdered(Object object, long fieldOffset, long newValue) {
        UNSAFE_INSTANCE.putLongVolatile(object, fieldOffset, newValue);
    }

    public static void setObjectOrdered(Object object, long fieldOffset, Object newValue) {
        UNSAFE_INSTANCE.putObjectVolatile(object, fieldOffset, newValue);
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
