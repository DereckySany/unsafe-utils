package io.github.thepun.unsafe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OffHeapAccessTest {

    @Test
    public void getAndSetByteByOffset() {
        long address = OffHeapMemory.allocate(100);
        long offset = 10;
        OffHeapMemory.setByte(address + offset, (byte) 33);

        byte value = OffHeapMemory.getByte(address + offset);
        assertEquals(33, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetByteByIndex() {
        long address = OffHeapMemory.allocate(100);
        OffHeapMemory.setByte(address, 98,  (byte) 43);

        byte value = OffHeapMemory.getByte(address, 98);
        assertEquals(43, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetIntByOffset() {
        long address = OffHeapMemory.allocate(100 * SystemTypeSizes.intSize());
        long offset = SystemTypeSizes.intSize() * 10;
        OffHeapMemory.setInt(address + offset, 123);

        int value = OffHeapMemory.getInt(address + offset);
        assertEquals(123, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetIntByIndex() {
        long address = OffHeapMemory.allocate(100 * SystemTypeSizes.intSize());
        OffHeapMemory.setInt(address, 15,  222);

        int value = OffHeapMemory.getInt(address, 15);
        assertEquals(222, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetShortByOffset() {
        long address = OffHeapMemory.allocate(100 * SystemTypeSizes.shortSize());
        long offset = SystemTypeSizes.shortSize() * 54;
        OffHeapMemory.setShort(address + offset, (short) 12323);

        short value = OffHeapMemory.getShort(address + offset);
        assertEquals(12323, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetShortByIndex() {
        long address = OffHeapMemory.allocate(100 * SystemTypeSizes.shortSize());
        OffHeapMemory.setShort(address, 0,  (short) 555);

        short value = OffHeapMemory.getShort(address, 0);
        assertEquals(555, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetCharByOffset() {
        long address = OffHeapMemory.allocate(100 * SystemTypeSizes.charSize());
        long offset = SystemTypeSizes.shortSize() * 71;
        OffHeapMemory.setChar(address + offset, 'a');

        char value = OffHeapMemory.getChar(address + offset);
        assertEquals('a', value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetCharByIndex() {
        long address = OffHeapMemory.allocate(100 * SystemTypeSizes.charSize());
        OffHeapMemory.setChar(address, 93,  'b');

        char value = OffHeapMemory.getChar(address, 93);
        assertEquals('b', value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetLongByOffset() {
        long address = OffHeapMemory.allocate(100 * SystemTypeSizes.longSize());
        long offset = SystemTypeSizes.longSize() * 67;
        OffHeapMemory.setLong(address + offset, 354673567L);

        long value = OffHeapMemory.getLong(address + offset);
        assertEquals(354673567L, value);

        OffHeapMemory.free(address);
    }

    @Test
    public void getAndSetLongByIndex() {
        long address = OffHeapMemory.allocate(100 * SystemTypeSizes.longSize());
        OffHeapMemory.setLong(address, 99,  56785678567867L);

        long value = OffHeapMemory.getLong(address, 99);
        assertEquals(56785678567867L, value);

        OffHeapMemory.free(address);
    }
}
