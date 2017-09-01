package org.thepun.unsafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayIntTest {

    private int[] array;

    @Before
    public void prepareArray() {
        array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i;
        }
    }

    @Test
    public void getByIndex() {
        int value = ArrayMemory.getInt(array, 4);
        assertEquals(4, value);
    }

    @Test
    public void getByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(int[].class, 2);
        int value = ArrayMemory.getInt(array, offset);
        assertEquals(2, value);
    }

    @Test
    public void getVolatileByIndex() {
        int value = ArrayMemory.getIntVolatile(array, 10);
        assertEquals(10, value);
    }

    @Test
    public void getVolatileByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(int[].class, 11);
        int value = ArrayMemory.getIntVolatile(array, offset);
        assertEquals(11, value);
    }

    @Test
    public void setByIndex() {
        ArrayMemory.setInt(array, 7, 99);
        int value = array[7];
        assertEquals(99, value);
    }

    @Test
    public void setByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(int[].class, 66);
        ArrayMemory.setInt(array, offset, 4567);
        int value = array[66];
        assertEquals(4567, value);
    }

    @Test
    public void setVolatileByIndex() {
        ArrayMemory.setIntVolatile(array, 3, 88);
        int value = array[3];
        assertEquals(88, value);
    }

    @Test
    public void setVolatileByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(int[].class, 34);
        ArrayMemory.setIntVolatile(array, offset, 1234);
        int value = array[34];
        assertEquals(1234, value);
    }

    @Test
    public void setOrderedByIndex() {
        ArrayMemory.setIntOrdered(array, 5, 23);
        int value = array[5];
        assertEquals(23, value);
    }

    @Test
    public void setOrderedByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(int[].class, 55);
        ArrayMemory.setIntOrdered(array, offset, 87);
        int value = array[55];
        assertEquals(87, value);
    }

    @Test
    public void casSuccessByIndex() {
        boolean cas = ArrayMemory.compareAndSwapInt(array, 75, 75, 99);
        assertTrue(cas);

        int value = array[75];
        assertEquals(99, value);
    }

    @Test
    public void casSuccessByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(int[].class, 91);
        boolean cas = ArrayMemory.compareAndSwapInt(array, offset, 91, 2);
        assertTrue(cas);

        int value = array[91];
        assertEquals(2, value);
    }

    @Test
    public void casFailureByIndex() {
        boolean cas = ArrayMemory.compareAndSwapInt(array, 55, 54, 123);
        assertFalse(cas);

        int value = array[55];
        assertEquals(55, value);
    }

    @Test
    public void casFailureByOffset() {
        long offset = ArrayMemoryLayout.getElementOffset(int[].class, 43);
        boolean cas = ArrayMemory.compareAndSwapInt(array, offset, 77, 456);
        assertFalse(cas);

        int value = array[43];
        assertEquals(43, value);
    }
}
