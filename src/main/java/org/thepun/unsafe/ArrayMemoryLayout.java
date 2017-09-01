package org.thepun.unsafe;

public final class ArrayMemoryLayout {

    public static <T> long getElementOffset(Class<?> arrayClass, int index) {
        if (!arrayClass.isArray()) {
            throw new IllegalArgumentException("Not an array class");
        }

        return UnsafeLocator.getUnsafe().arrayBaseOffset(arrayClass) + getElementSize(arrayClass) * index;
    }

    public static <T> int getElementSize(Class<?> arrayClass) {
        if (!arrayClass.isArray()) {
            throw new IllegalArgumentException("Not an array class");
        }

        return UnsafeLocator.getUnsafe().arrayIndexScale(arrayClass);
    }



    private ArrayMemoryLayout() {
    }
}
