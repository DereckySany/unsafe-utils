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

}
