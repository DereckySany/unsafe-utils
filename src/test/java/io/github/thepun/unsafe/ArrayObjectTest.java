package io.github.thepun.unsafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArrayObjectTest {

    private Object[] array;

    @Before
    public void prepareArray() {
        array = new Object[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i;
        }
    }

    @Test
    public void getByIndex() {
        Object value = ArrayMemory.getObject(array, 4);
        assertEquals(4, value);
    }

    @Test
    public void getByOffset() {
        long offset = SystemTypeSizes.referenceSize() * 2 + ArrayMemory.firstElementOffset();
        Object value = ArrayMemory.getObject(array, offset);
        assertEquals(2, value);
    }

    @Test
    public void getVolatileByIndex() {
        Object value = ArrayMemory.getObjectVolatile(array, 10);
        assertEquals(10, value);
    }

    @Test
    public void getVolatileByOffset() {
        long offset = SystemTypeSizes.referenceSize() * 11 + ArrayMemory.firstElementOffset();
        Object value = ArrayMemory.getObjectVolatile(array, offset);
        assertEquals(11, value);
    }

    @Test
    public void setByIndex() {
        ArrayMemory.setObject(array, 7, 99);
        Object value = array[7];
        assertEquals(99, value);
    }

    @Test
    public void setByOffset() {
        long offset = SystemTypeSizes.referenceSize() * 66 + ArrayMemory.firstElementOffset();
        ArrayMemory.setObject(array, offset, 4567);
        Object value = array[66];
        assertEquals(4567, value);
    }

    @Test
    public void setVolatileByIndex() {
        ArrayMemory.setObjectVolatile(array, 3, 88);
        Object value = array[3];
        assertEquals(88, value);
    }

    @Test
    public void setVolatileByOffset() {
        long offset = SystemTypeSizes.referenceSize() * 34 + ArrayMemory.firstElementOffset();
        ArrayMemory.setObjectVolatile(array, offset, 1234);
        Object value = array[34];
        assertEquals(1234, value);
    }

    @Test
    public void setOrderedByIndex() {
        ArrayMemory.setObjectOrdered(array, 5, 23);
        Object value = array[5];
        assertEquals(23, value);
    }

    @Test
    public void setOrderedByOffset() {
        long offset = SystemTypeSizes.referenceSize() * 55 + ArrayMemory.firstElementOffset();
        ArrayMemory.setObjectOrdered(array, offset, 87);
        Object value = array[55];
        assertEquals(87, value);
    }

    @Test
    public void casSuccessByIndex() {
        boolean cas = ArrayMemory.compareAndSwapObject(array, 75, 75, 99);
        assertTrue(cas);

        Object value = array[75];
        assertEquals(99, value);
    }

    @Test
    public void casSuccessByOffset() {
        long offset = SystemTypeSizes.referenceSize() * 91 + ArrayMemory.firstElementOffset();
        boolean cas = ArrayMemory.compareAndSwapObject(array, offset, 91, 2);
        assertTrue(cas);

        Object value = array[91];
        assertEquals(2, value);
    }

    @Test
    public void casFailureByIndex() {
        boolean cas = ArrayMemory.compareAndSwapObject(array, 55, 54, 123);
        assertFalse(cas);

        Object value = array[55];
        assertEquals(55, value);
    }

    @Test
    public void casFailureByOffset() {
        long offset = SystemTypeSizes.referenceSize() * 43 + ArrayMemory.firstElementOffset();
        boolean cas = ArrayMemory.compareAndSwapObject(array, offset, 77, 456);
        assertFalse(cas);

        Object value = array[43];
        assertEquals(43, value);
    }

}
