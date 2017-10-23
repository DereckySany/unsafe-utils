package io.github.thepun.unsafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayExchangeTest {

    @Test
    public void getAndSetIntByIndex() {
        int[] array = new int[100];
        array[79] = 123;

        int prevValue = ArrayMemory.getAndSetInt(array, 79, 54);
        assertEquals(123, prevValue);

        int currentValue = array[79];
        assertEquals(54, currentValue);
    }

    @Test
    public void getAndSetIntByOffset() {
        int[] array = new int[100];
        array[33] = 98;

        long offset = ArrayMemoryLayout.getElementOffset(int[].class, 33);
        int prevValue = ArrayMemory.getAndSetInt(array, offset, 6666);
        assertEquals(98, prevValue);

        int currentValue = array[33];
        assertEquals(6666, currentValue);
    }

    @Test
    public void getAndAddIntByIndex() {
        int[] array = new int[100];
        array[22] = 4678467;

        int prevValue = ArrayMemory.getAndAddInt(array, 22, 123);
        assertEquals(4678467, prevValue);

        int currentValue = array[22];
        assertEquals(4678467 + 123, currentValue);
    }

    @Test
    public void getAndAddIntByOffset() {
        int[] array = new int[100];
        array[66] = 1234;

        long offset = ArrayMemoryLayout.getElementOffset(int[].class, 66);
        int prevValue = ArrayMemory.getAndAddInt(array, offset, 555);
        assertEquals(1234, prevValue);

        int currentValue = array[66];
        assertEquals(1234 + 555, currentValue);
    }

    @Test
    public void getAndSetLongByIndex() {
        long[] array = new long[100];
        array[79] = 123;

        long prevValue = ArrayMemory.getAndSetLong(array, 79, 54);
        assertEquals(123, prevValue);

        long currentValue = array[79];
        assertEquals(54, currentValue);
    }

    @Test
    public void getAndSetLongByOffset() {
        long[] array = new long[100];
        array[76] = 2345345L;

        long offset = ArrayMemoryLayout.getElementOffset(long[].class, 76);
        long prevValue = ArrayMemory.getAndSetLong(array, offset, 88888888L);
        assertEquals(2345345L, prevValue);

        long currentValue = array[76];
        assertEquals(88888888L, currentValue);
    }

    @Test
    public void getAndAddLongByIndex() {
        long[] array = new long[100];
        array[1] = 5L;

        long prevValue = ArrayMemory.getAndAddLong(array, 1, 2345L);
        assertEquals(5L, prevValue);

        long currentValue = array[1];
        assertEquals(5L + 2345L, currentValue);
    }

    @Test
    public void getAndAddLongByOffset() {
        long[] array = new long[100];
        array[94] = 65785678L;

        long offset = ArrayMemoryLayout.getElementOffset(long[].class, 94);
        long prevValue = ArrayMemory.getAndAddLong(array, offset, 5524356456L);
        assertEquals(65785678L, prevValue);

        long currentValue = array[94];
        assertEquals(65785678L + 5524356456L, currentValue);
    }

    @Test
    public void getAndSetObjectByIndex() {
        Object[] array = new Object[100];
        array[3] = "adsfgadsfg";

        Object prevValue = ArrayMemory.getAndSetObject(array, 3, "tyuhioutio");
        assertEquals("adsfgadsfg", prevValue);

        Object currentValue = array[3];
        assertEquals("tyuhioutio", currentValue);
    }

    @Test
    public void getAndSetObjectByOffset() {
        Object[] array = new Object[100];
        array[13] = "sdfgsdgfdgsdfg";

        long offset = ArrayMemoryLayout.getElementOffset(Object[].class, 13);
        Object prevValue = ArrayMemory.getAndSetObject(array, offset, "zzzzzz");
        assertEquals("sdfgsdgfdgsdfg", prevValue);

        Object currentValue = array[13];
        assertEquals("zzzzzz", currentValue);
    }
}
