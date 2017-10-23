package io.github.thepun.unsafe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ObjectExchangeTest {

    @Test
    public void getAndSetInt() {
        TestClass obj = new TestClass();
        obj.field1 = 6456;

        long fieldOffset = ObjectMemoryLayout.getFieldOffset(TestClass.class, "field1");
        int prevValue = ObjectMemory.getAndSetInt(obj, fieldOffset, 11111);
        assertEquals(6456, prevValue);

        int currentValue = obj.field1;
        assertEquals(11111, currentValue);
    }

    @Test
    public void getAndSetLong() {
        TestClass obj = new TestClass();
        obj.field2 = 4356756756L;

        long fieldOffset = ObjectMemoryLayout.getFieldOffset(TestClass.class, "field2");
        long prevValue = ObjectMemory.getAndSetLong(obj, fieldOffset, 354674567L);
        assertEquals(4356756756L, prevValue);

        long currentValue = obj.field2;
        assertEquals(354674567L, currentValue);
    }

    @Test
    public void getAndSetObject() {
        TestClass obj = new TestClass();
        obj.field3 = "zxcvzxcvbncv";

        long fieldOffset = ObjectMemoryLayout.getFieldOffset(TestClass.class, "field3");
        Object prevValue = ObjectMemory.getAndSetObject(obj, fieldOffset, "234234");
        assertEquals("zxcvzxcvbncv", prevValue);

        Object currentValue = obj.field3;
        assertEquals("234234", currentValue);
    }

    @Test
    public void getAndAddInt() {
        TestClass obj = new TestClass();
        obj.field1 = 234234;

        long fieldOffset = ObjectMemoryLayout.getFieldOffset(TestClass.class, "field1");
        int prevValue = ObjectMemory.getAndAddInt(obj, fieldOffset, 465786);
        assertEquals(234234, prevValue);

        int currentValue = obj.field1;
        assertEquals(234234 + 465786, currentValue);
    }


    private class TestClass {

        private int field1;
        private long field2;
        private Object field3;

    }
}
