package io.github.thepun.unsafe;

/**
 * Utility class for accessing object memory.
 *
 * All methods require fieldOffset which can be retrieved by {@link ObjectMemoryLayout} and cached.
 */
public class ObjectMemory {

    public static int getInt(Object object, long fieldOffset) {
        return UnsafeLocator.getUnsafe().getInt(object, fieldOffset);
    }

    public static long getLong(Object object, long fieldOffset) {
        return UnsafeLocator.getUnsafe().getLong(object, fieldOffset);
    }

    public static Object getObject(Object object, long fieldOffset) {
        return UnsafeLocator.getUnsafe().getObject(object, fieldOffset);
    }

    public static void setInt(Object object, long fieldOffset, int newValue) {
        UnsafeLocator.getUnsafe().putInt(object, fieldOffset, newValue);
    }

    public static void setLong(Object object, long fieldOffset, long newValue) {
        UnsafeLocator.getUnsafe().putLong(object, fieldOffset, newValue);
    }

    public static void setObject(Object object, long fieldOffset, Object newValue) {
        UnsafeLocator.getUnsafe().putObject(object, fieldOffset, newValue);
    }

    public static int getIntVolatile(Object object, long fieldOffset) {
        return UnsafeLocator.getUnsafe().getIntVolatile(object, fieldOffset);
    }

    public static long getLongVolatile(Object object, long fieldOffset) {
        return UnsafeLocator.getUnsafe().getLongVolatile(object, fieldOffset);
    }

    public static Object getObjectVolatile(Object object, long fieldOffset) {
        return UnsafeLocator.getUnsafe().getObjectVolatile(object, fieldOffset);
    }

    public static void setIntVolatile(Object object, long fieldOffset, int newValue) {
        UnsafeLocator.getUnsafe().putIntVolatile(object, fieldOffset, newValue);
    }

    public static void setLongVolatile(Object object, long fieldOffset, long newValue) {
        UnsafeLocator.getUnsafe().putLongVolatile(object, fieldOffset, newValue);
    }

    public static void setObjectVolatile(Object object, long fieldOffset, Object newValue) {
        UnsafeLocator.getUnsafe().putObjectVolatile(object, fieldOffset, newValue);
    }

    public static void setIntOrdered(Object object, long fieldOffset, int newValue) {
        UnsafeLocator.getUnsafe().putIntVolatile(object, fieldOffset, newValue);
    }

    public static void setLongOrdered(Object object, long fieldOffset, long newValue) {
        UnsafeLocator.getUnsafe().putLongVolatile(object, fieldOffset, newValue);
    }

    public static void setObjectOrdered(Object object, long fieldOffset, Object newValue) {
        UnsafeLocator.getUnsafe().putObjectVolatile(object, fieldOffset, newValue);
    }

    public static boolean compareAndSwapInt(Object object, long fieldOffset, int expectedValue, int newValue) {
        return UnsafeLocator.getUnsafe().compareAndSwapInt(object, fieldOffset, expectedValue, newValue);
    }

    public static boolean compareAndSwapLong(Object object, long fieldOffset, long expectedValue, long newValue) {
        return UnsafeLocator.getUnsafe().compareAndSwapLong(object, fieldOffset, expectedValue, newValue);
    }

    public static boolean compareAndSwapObject(Object object, long fieldOffset, Object expectedValue, Object newValue) {
        return UnsafeLocator.getUnsafe().compareAndSwapObject(object, fieldOffset, expectedValue, newValue);
    }

    public static int getAndSetInt(Object object, long fieldOffset, int value) {
        return UnsafeLocator.getUnsafe().getAndSetInt(object, fieldOffset, value);
    }

    public static long getAndSetLong(Object object, long fieldOffset, long value) {
        return UnsafeLocator.getUnsafe().getAndSetLong(object, fieldOffset, value);
    }

    public static Object getAndSetObject(Object object, long fieldOffset, Object value) {
        return UnsafeLocator.getUnsafe().getAndSetObject(object, fieldOffset, value);
    }

    public static int getAndAddInt(Object object, long fieldOffset, int delta) {
        return UnsafeLocator.getUnsafe().getAndAddInt(object, fieldOffset, delta);
    }

    public static long getAndAddLong(Object object, long fieldOffset, long delta) {
        return UnsafeLocator.getUnsafe().getAndAddLong(object, fieldOffset, delta);
    }


    private ObjectMemory() {
    }
}
