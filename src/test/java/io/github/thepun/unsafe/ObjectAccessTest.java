package io.github.thepun.unsafe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ObjectAccessTest {

    @Test
    public void getInt() {
        TestClass obj = new TestClass();
        obj.intField = 123;

        long intField = ObjectMemory.fieldOffset(TestClass.class, "intField");
        int value = ObjectMemory.getInt(obj, intField);
        assertEquals(123, value);
    }

    @Test
    public void getIntVolatile() {
        TestClass obj = new TestClass();
        obj.intField = 6789;

        long intField = ObjectMemory.fieldOffset(TestClass.class, "intField");
        int value = ObjectMemory.getIntVolatile(obj, intField);
        assertEquals(6789, value);
    }

    @Test
    public void getLong() {
        TestClass obj = new TestClass();
        obj.longField = 4567891234L;

        long longField = ObjectMemory.fieldOffset(TestClass.class, "longField");
        long value = ObjectMemory.getLong(obj, longField);
        assertEquals(4567891234L, value);
    }

    @Test
    public void getLongVolatile() {
        TestClass obj = new TestClass();
        obj.longField = 6754524L;

        long longField = ObjectMemory.fieldOffset(TestClass.class, "longField");
        long value = ObjectMemory.getLongVolatile(obj, longField);
        assertEquals(6754524L, value);
    }

    @Test
    public void getObject() {
        TestClass obj = new TestClass();
        obj.objectField = "asdfasdfgasdfg";

        long objectField = ObjectMemory.fieldOffset(TestClass.class, "objectField");
        Object value = ObjectMemory.getObject(obj, objectField);
        assertEquals("asdfasdfgasdfg", value);
    }

    @Test
    public void getObjectVolatile() {
        TestClass obj = new TestClass();
        obj.objectField = "uyioyuijo";

        long objectField = ObjectMemory.fieldOffset(TestClass.class, "objectField");
        Object value = ObjectMemory.getObjectVolatile(obj, objectField);
        assertEquals("uyioyuijo", value);
    }

    @Test
    public void setInt() {
        TestClass obj = new TestClass();

        long intField = ObjectMemory.fieldOffset(TestClass.class, "intField");
        ObjectMemory.setInt(obj, intField, 456);

        assertEquals(456, obj.intField);
    }

    @Test
    public void setIntVolatile() {
        TestClass obj = new TestClass();

        long intField = ObjectMemory.fieldOffset(TestClass.class, "intField");
        ObjectMemory.setIntVolatile(obj, intField, 333);

        assertEquals(333, obj.intField);
    }

    @Test
    public void setIntOrdered() {
        TestClass obj = new TestClass();

        long intField = ObjectMemory.fieldOffset(TestClass.class, "intField");
        ObjectMemory.setIntOrdered(obj, intField, 88888);

        assertEquals(88888, obj.intField);
    }

    @Test
    public void setLong() {
        TestClass obj = new TestClass();

        long longField = ObjectMemory.fieldOffset(TestClass.class, "longField");
        ObjectMemory.setLong(obj, longField, 98765432198L);

        assertEquals(98765432198L, obj.longField);
    }

    @Test
    public void setLongVolatile() {
        TestClass obj = new TestClass();

        long longField = ObjectMemory.fieldOffset(TestClass.class, "longField");
        ObjectMemory.setLongVolatile(obj, longField, 32423456432198L);

        assertEquals(32423456432198L, obj.longField);
    }

    @Test
    public void setLongOrdered() {
        TestClass obj = new TestClass();

        long longField = ObjectMemory.fieldOffset(TestClass.class, "longField");
        ObjectMemory.setLongOrdered(obj, longField, 54656565198L);

        assertEquals(54656565198L, obj.longField);
    }

    @Test
    public void setObject() {
        TestClass obj = new TestClass();

        long objectField = ObjectMemory.fieldOffset(TestClass.class, "objectField");
        ObjectMemory.setObject(obj, objectField, "mnbvcxz");

        assertEquals("mnbvcxz", obj.objectField);
    }

    @Test
    public void setObjectVolatile() {
        TestClass obj = new TestClass();

        long objectField = ObjectMemory.fieldOffset(TestClass.class, "objectField");
        ObjectMemory.setObjectVolatile(obj, objectField, "zndnznzdnf");

        assertEquals("zndnznzdnf", obj.objectField);
    }

    @Test
    public void setObjectOrdered() {
        TestClass obj = new TestClass();

        long objectField = ObjectMemory.fieldOffset(TestClass.class, "objectField");
        ObjectMemory.setObjectOrdered(obj, objectField, "sdfdfhdrfhg");

        assertEquals("sdfdfhdrfhg", obj.objectField);
    }

    private static class TestClass {
        private int intField;
        private long longField;
        private Object objectField;
    }
}
