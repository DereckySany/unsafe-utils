package io.github.thepun.unsafe;

import sun.misc.Unsafe;

/**
 * Allows to get access to raw off-heap memory.
 *
 * Memory should be allocated and freed manually.
 */
public class OffHeapMemory {

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

    public static byte getByte(long address, int index) {
        return UNSAFE_INSTANCE.getByte(address + index);
    }

    public static char getChar(long address) {
        return UNSAFE_INSTANCE.getChar(address);
    }

    public static char getChar(long address, int index) {
        return UNSAFE_INSTANCE.getChar(address + index * 2);
    }

    public static short getShort(long address) {
        return UNSAFE_INSTANCE.getShort(address);
    }

    public static short getShort(long address, int index) {
        return UNSAFE_INSTANCE.getShort(address + index * 2);
    }

    public static int getInt(long address) {
        return UNSAFE_INSTANCE.getInt(address);
    }

    public static int getInt(long address, int index) {
        return UNSAFE_INSTANCE.getInt(address, address + index * 4);
    }

    public static long getLong(long address) {
        return UNSAFE_INSTANCE.getLong(address);
    }

    public static long getLong(long address, int index) {
        return UNSAFE_INSTANCE.getLong(address, address + index * 8);
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
        UNSAFE_INSTANCE.putChar(address + index * 2, value);
    }

    public static void setShort(long address, short value) {
        UNSAFE_INSTANCE.putShort(address, value);
    }

    public static void setShort(long address, int index, short value) {
        UNSAFE_INSTANCE.putShort(address + index * 2, value);
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
        UNSAFE_INSTANCE.putLong(address + index * 8, value);
    }

    private OffHeapMemory() {
    }
}
