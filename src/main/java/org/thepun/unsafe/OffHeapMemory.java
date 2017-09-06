package org.thepun.unsafe;

/**
 * Allows to get access to raw off-heap memory.
 *
 * Memory should be allocated and freed manually.
 */
public class OffHeapMemory {

    public static long allocate(int size) {
        return UnsafeLocator.getUnsafe().allocateMemory(size);
    }

    public static long allocateForLong(int size) {
        return UnsafeLocator.getUnsafe().allocateMemory(size * 8);
    }

    public static long allocateForInt(int size) {
        return UnsafeLocator.getUnsafe().allocateMemory(size * 4);
    }

    public static long allocateForCharOrShort(int size) {
        return UnsafeLocator.getUnsafe().allocateMemory(size * 2);
    }

    public static void free(long address) {
        UnsafeLocator.getUnsafe().freeMemory(address);
    }

    public static byte getByte(long address) {
        return UnsafeLocator.getUnsafe().getByte(address);
    }

    public static byte getByte(long address, int index) {
        return UnsafeLocator.getUnsafe().getByte(address + index);
    }

    public static char getChar(long address) {
        return UnsafeLocator.getUnsafe().getChar(address);
    }

    public static char getChar(long address, int index) {
        return UnsafeLocator.getUnsafe().getChar(address + index * 2);
    }

    public static short getShort(long address) {
        return UnsafeLocator.getUnsafe().getShort(address);
    }

    public static short getShort(long address, int index) {
        return UnsafeLocator.getUnsafe().getShort(address + index * 2);
    }

    public static int getInt(long address) {
        return UnsafeLocator.getUnsafe().getInt(address);
    }

    public static int getInt(long address, int index) {
        return UnsafeLocator.getUnsafe().getInt(address, address + index * 4);
    }

    public static long getLong(long address) {
        return UnsafeLocator.getUnsafe().getLong(address);
    }

    public static long getLong(long address, int index) {
        return UnsafeLocator.getUnsafe().getLong(address, address + index * 8);
    }

    public static void setByte(long address, byte value) {
        UnsafeLocator.getUnsafe().putByte(address, value);
    }

    public static void setByte(long address, int index, byte value) {
        UnsafeLocator.getUnsafe().putByte(address + index, value);
    }

    public static void setChar(long address, char value) {
        UnsafeLocator.getUnsafe().putChar(address, value);
    }

    public static void setChar(long address, int index, char value) {
        UnsafeLocator.getUnsafe().putChar(address + index * 2, value);
    }

    public static void setShort(long address, short value) {
        UnsafeLocator.getUnsafe().putShort(address, value);
    }

    public static void setShort(long address, int index, short value) {
        UnsafeLocator.getUnsafe().putShort(address + index * 2, value);
    }

    public static void setInt(long address, int value) {
        UnsafeLocator.getUnsafe().putInt(address, value);
    }

    public static void setInt(long address, int index, int value) {
        UnsafeLocator.getUnsafe().putInt(address + index * 4, value);
    }

    public static void setLong(long address, long value) {
        UnsafeLocator.getUnsafe().putLong(address, value);
    }

    public static void setLong(long address, int index, long value) {
        UnsafeLocator.getUnsafe().putLong(address + index * 8, value);
    }

    private OffHeapMemory() {
    }
}
