package io.github.thepun.unsafe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OffHeapArrayTest {

    @Test
    public void copyBytes() {
        long address = OffHeapMemory.allocate(10);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setByte(address + i, (byte) (i * 3));
        }

        byte[] bytes = new byte[10];
        OffHeapMemory.copyToArray(address, bytes, 0, 10);

        for (int i = 0; i < bytes.length; i++) {
            assertEquals(i * 3, bytes[i]);
        }
    }

    @Test
    public void copyBytesWithOffset() {
        long address = OffHeapMemory.allocate(10);
        for (int i = 0; i < 10; i++) {
            OffHeapMemory.setByte(address + i, (byte) (i * 3));
        }

        byte[] bytes = new byte[10];
        OffHeapMemory.copyToArray(address, bytes, 0, 10);

        for (int i = 0; i < bytes.length; i++) {
            assertEquals(i * 3, bytes[i]);
        }
    }
}
