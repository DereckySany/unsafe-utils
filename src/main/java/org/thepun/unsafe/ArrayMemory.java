package org.thepun.unsafe;

/**
 * Utility class for accessing array memory.
 *
 * Index is ordinary array index.
 *
 * Offset is calculated as ELEMENT_SIZE * INDEX + FIRST_ELEMENT_OFFSET. Element size and first element offset can be calculated with ArrayMemoryLayout class.
 */
public final class ArrayMemory {

    private static final int INT_SIZE = ArrayMemoryLayout.getElementSize(Object[].class);
    private static final int LONG_SIZE = ArrayMemoryLayout.getElementSize(Object[].class);
    private static final int OBJECT_SIZE = ArrayMemoryLayout.getElementSize(Object[].class);
    private static final long INT_OFFSET = ArrayMemoryLayout.getElementOffset(int[].class, 0);
    private static final long LONG_OFFSET = ArrayMemoryLayout.getElementOffset(long[].class, 0);
    private static final long OBJECT_OFFSET = ArrayMemoryLayout.getElementOffset(Object[].class, 0);


    public static int getInt(int[] array, int index) {
        return getInt(array, INT_OFFSET + INT_SIZE * index);
    }

    public static void setInt(int[] array, int index, int element) {
        setInt(array, INT_OFFSET + INT_SIZE * index, element);
    }

    public static int getIntVolatile(int[] array, int index) {
        return UnsafeLocator.getUnsafe().getIntVolatile(array, INT_OFFSET + INT_SIZE * index);
    }

    public static void setIntVolatile(int[] array, int index, int element) {
        UnsafeLocator.getUnsafe().putIntVolatile(array, INT_OFFSET + INT_SIZE * index, element);
    }

    public static void setIntOrdered(int[] array, int index, int element) {
        UnsafeLocator.getUnsafe().putOrderedInt(array, INT_OFFSET + INT_SIZE * index, element);
    }

    public static boolean compareAndSwapInt(int[] array, int index, int expectedElement, int newElement) {
        return UnsafeLocator.getUnsafe().compareAndSwapInt(array, INT_OFFSET + INT_SIZE * index, expectedElement, newElement);
    }

    public static int getAndSetInt(int[] array, int index, int element) {
        return UnsafeLocator.getUnsafe().getAndAddInt(array, INT_OFFSET + INT_SIZE * index, element);
    }

    public static int getInt(int[] array, long offset) {
        return UnsafeLocator.getUnsafe().getInt(array, offset);
    }

    public static void setInt(int[] array, long offset, int element) {
        UnsafeLocator.getUnsafe().putInt(array, offset, element);
    }

    public static int getIntVolatile(int[] array, long offset) {
        return UnsafeLocator.getUnsafe().getIntVolatile(array, offset);
    }

    public static void setIntVolatile(int[] array, long offset, int element) {
        UnsafeLocator.getUnsafe().putIntVolatile(array, offset, element);
    }

    public static void setIntOrdered(int[] array, long offset, int element) {
        UnsafeLocator.getUnsafe().putOrderedInt(array, offset, element);
    }

    public static boolean compareAndSwapInt(int[] array, long offset, int expectedElement, int newElement) {
        return UnsafeLocator.getUnsafe().compareAndSwapInt(array, offset, expectedElement, newElement);
    }

    public static int getAndSetInt(int[] array, long offset, int element) {
        return UnsafeLocator.getUnsafe().getAndAddInt(array, offset, element);
    }

    public static long getLong(long[] array, int index) {
        return getLong(array, LONG_OFFSET + LONG_SIZE * index);
    }

    public static void setLong(long[] array, int index, long element) {
        setLong(array, LONG_OFFSET + LONG_SIZE * index, element);
    }

    public static long getLongVolatile(long[] array, int index) {
        return UnsafeLocator.getUnsafe().getLongVolatile(array, LONG_OFFSET + LONG_SIZE * index);
    }

    public static void setLongVolatile(long[] array, int index, long element) {
        UnsafeLocator.getUnsafe().putLongVolatile(array, LONG_OFFSET + LONG_SIZE * index, element);
    }

    public static void setLongOrdered(long[] array, int index, long element) {
        UnsafeLocator.getUnsafe().putOrderedLong(array, LONG_OFFSET + LONG_SIZE * index, element);
    }

    public static boolean compareAndSwapLong(long[] array, int index, long expectedElement, long newElement) {
        return UnsafeLocator.getUnsafe().compareAndSwapLong(array, LONG_OFFSET + LONG_SIZE * index, expectedElement, newElement);
    }

    public static long getAndSetLong(long[] array, int index, long element) {
        return UnsafeLocator.getUnsafe().getAndSetLong(array, LONG_OFFSET + LONG_SIZE * index, element);
    }

    public static long getLong(long[] array, long offset) {
        return UnsafeLocator.getUnsafe().getLong(array, offset);
    }

    public static void setLong(long[] array, long offset, long element) {
        UnsafeLocator.getUnsafe().putLong(array, offset, element);
    }

    public static long getLongVolatile(long[] array, long offset) {
        return UnsafeLocator.getUnsafe().getLongVolatile(array, offset);
    }

    public static void setLongVolatile(long[] array, long offset, long element) {
        UnsafeLocator.getUnsafe().putLongVolatile(array, offset, element);
    }

    public static void setLongOrdered(long[] array, long offset, long element) {
        UnsafeLocator.getUnsafe().putLongVolatile(array, offset, element);
    }

    public static boolean compareAndSwapLong(long[] array, long offset, long expectedElement, long newElement) {
        return UnsafeLocator.getUnsafe().compareAndSwapLong(array, offset, expectedElement, newElement);
    }

    public static long getAndSetLong(long[] array, long offset, long element) {
        return UnsafeLocator.getUnsafe().getAndSetLong(array, offset, element);
    }

    public static <T> T getObject(T[] array, int index) {
        return getObject(array, OBJECT_OFFSET + OBJECT_SIZE * index);
    }

    public static <T> void setObject(T[] array, int index, T element) {
        setObject(array, OBJECT_OFFSET + OBJECT_SIZE * index, element);
    }

    public static <T> Object getObjectVolatile(T[] array, int index) {
        return UnsafeLocator.getUnsafe().getObjectVolatile(array, OBJECT_OFFSET + OBJECT_SIZE * index);
    }

    public static <T> void setObjectVolatile(T[] array, int index, T element) {
        UnsafeLocator.getUnsafe().putObjectVolatile(array, OBJECT_OFFSET + OBJECT_SIZE * index, element);
    }

    public static <T> void setObjectOrdered(T[] array, int index, T element) {
        UnsafeLocator.getUnsafe().putOrderedObject(array, OBJECT_OFFSET + OBJECT_SIZE * index, element);
    }

    public static <T> boolean compareAndSwapObject(T[] array, int index, T expectedElement, T newElement) {
        return UnsafeLocator.getUnsafe().compareAndSwapObject(array, OBJECT_OFFSET + OBJECT_SIZE * index, expectedElement, newElement);
    }

    public static <T> T getAndSetObject(T[] array, int index, T element) {
        return (T) UnsafeLocator.getUnsafe().getAndSetObject(array, OBJECT_OFFSET + OBJECT_SIZE * index, element);
    }

    public static <T> T getObject(T[] array, long offset) {
        return (T) UnsafeLocator.getUnsafe().getObject(array, offset);
    }

    public static <T> void setObject(T[] array, long offset, T element) {
        UnsafeLocator.getUnsafe().putObject(array, offset, element);
    }

    public static <T> Object getObjectVolatile(T[] array, long offset) {
        return UnsafeLocator.getUnsafe().getObjectVolatile(array, offset);
    }

    public static <T> void setObjectVolatile(T[] array, long offset, T element) {
        UnsafeLocator.getUnsafe().putObjectVolatile(array, offset, element);
    }

    public static <T> void setObjectOrdered(T[] array, long offset, T element) {
        UnsafeLocator.getUnsafe().putObjectVolatile(array, offset, element);
    }

    public static <T> boolean compareAndSwapObject(T[] array, long offset, T expectedElement, T newElement) {
        return UnsafeLocator.getUnsafe().compareAndSwapObject(array, offset, expectedElement, newElement);
    }

    public static <T> T getAndSetObject(T[] array, long offset, T element) {
        return (T) UnsafeLocator.getUnsafe().getAndSetObject(array, offset, element);
    }


    private ArrayMemory() {
    }
}
