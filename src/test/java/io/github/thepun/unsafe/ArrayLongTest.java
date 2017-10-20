package io.github.thepun.unsafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayLongTest {

    private long[] array;

    @Before
    public void prepareArray() {
        array = new long[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i;
        }
    }

    @Test
    public void getByIndex() {
        long value = ArrayMemory.getLong(array, 4);
        assertEquals(4, value);
    }

    @Test
    public void getByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(long[].class, 2);
        long value = ArrayMemory.getLong(array, offset);
        assertEquals(2, value);
    }

    @Test
    public void getVolatileByIndex() {
        long value = ArrayMemory.getLongVolatile(array, 10);
        assertEquals(10, value);
    }

    @Test
    public void getVolatileByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(long[].class, 11);
        long value = ArrayMemory.getLongVolatile(array, offset);
        assertEquals(11, value);
    }

    @Test
    public void setByIndex() {
        ArrayMemory.setLong(array, 7, 99);
        long value = array[7];
        assertEquals(99, value);
    }

    @Test
    public void setByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(long[].class, 66);
        ArrayMemory.setLong(array, offset, 4567);
        long value = array[66];
        assertEquals(4567, value);
    }

    @Test
    public void setVolatileByIndex() {
        ArrayMemory.setLongVolatile(array, 3, 88);
        long value = array[3];
        assertEquals(88, value);
    }

    @Test
    public void setVolatileByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(long[].class, 34);
        ArrayMemory.setLongVolatile(array, offset, 1234);
        long value = array[34];
        assertEquals(1234, value);
    }

    @Test
    public void setOrderedByIndex() {
        ArrayMemory.setLongOrdered(array, 5, 23);
        long value = array[5];
        assertEquals(23, value);
    }

    @Test
    public void setOrderedByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(long[].class, 55);
        ArrayMemory.setLongOrdered(array, offset, 87);
        long value = array[55];
        assertEquals(87, value);
    }

    @Test
    public void casSuccessByIndex() {
        boolean cas = ArrayMemory.compareAndSwapLong(array, 75, 75, 99);
        assertTrue(cas);

        long value = array[75];
        assertEquals(99, value);
    }

    @Test
    public void casSuccessByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(long[].class, 91);
        boolean cas = ArrayMemory.compareAndSwapLong(array, offset, 91, 2);
        assertTrue(cas);

        long value = array[91];
        assertEquals(2, value);
    }

    @Test
    public void casFailureByIndex() {
        boolean cas = ArrayMemory.compareAndSwapLong(array, 55, 54, 123);
        assertFalse(cas);

        long value = array[55];
        assertEquals(55, value);
    }

    @Test
    public void casFailureByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(long[].class, 43);
        boolean cas = ArrayMemory.compareAndSwapLong(array, offset, 77, 456);
        assertFalse(cas);

        long value = array[43];
        assertEquals(43, value);
    }
}
