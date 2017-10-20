package io.github.thepun.unsafe;

/**
 * Allows to get internal sizes of array structure.
 *
 * Array layout:
 *  [ header ] [ length ] [ element0 ] ... [ elementN ]
 *
 * To get X'th element from array you with offset you have to calculate it.
 * Element offset is calculated with formula OFFSET = HEADER_SIZE + LENGTH_SIZE + INDEX * ELEMENT_SIZE or
 * OFFSET = FIRST_ELEMENT_OFFSET + INDEX * ELEMENT_SIZE
 */
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
