package io.github.thepun.unsafe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OffHeapArrayCopyFromTest {

    @Test
    public void copyBytes() {
        byte[] bytes = new byte[10];
        for (int i = 0; i < 10; i++) {
            bytes[i] = (byte) (i * 5);
        }

        long address = OffHeapMemory.allocate(10);
        OffHeapMemory.copyFromArray(address, bytes);

        for (int i = 0; i < bytes.length; i++) {
            assertEquals(i * 5, OffHeapMemory.getByte(address + i));
        }
    }

}
