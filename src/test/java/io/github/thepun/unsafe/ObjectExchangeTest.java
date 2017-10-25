/**
 * Copyright (C)2011 - Marat Gariev <thepun599@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.thepun.unsafe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ObjectExchangeTest {

    @Test
    public void getAndSetInt() {
        TestClass obj = new TestClass();
        obj.field1 = 6456;

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field1");
        int prevValue = ObjectMemory.getAndSetInt(obj, fieldOffset, 11111);
        assertEquals(6456, prevValue);

        int currentValue = obj.field1;
        assertEquals(11111, currentValue);
    }

    @Test
    public void getAndSetLong() {
        TestClass obj = new TestClass();
        obj.field2 = 4356756756L;

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field2");
        long prevValue = ObjectMemory.getAndSetLong(obj, fieldOffset, 354674567L);
        assertEquals(4356756756L, prevValue);

        long currentValue = obj.field2;
        assertEquals(354674567L, currentValue);
    }

    @Test
    public void getAndSetObject() {
        TestClass obj = new TestClass();
        obj.field3 = "zxcvzxcvbncv";

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field3");
        Object prevValue = ObjectMemory.getAndSetObject(obj, fieldOffset, "234234");
        assertEquals("zxcvzxcvbncv", prevValue);

        Object currentValue = obj.field3;
        assertEquals("234234", currentValue);
    }

    @Test
    public void getAndAddInt() {
        TestClass obj = new TestClass();
        obj.field1 = 234234;

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field1");
        int prevValue = ObjectMemory.getAndAddInt(obj, fieldOffset, 465786);
        assertEquals(234234, prevValue);

        int currentValue = obj.field1;
        assertEquals(234234 + 465786, currentValue);
    }

    @Test
    public void getAndAddLong() {
        TestClass obj = new TestClass();
        obj.field2 = 777777777L;

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field2");
        long prevValue = ObjectMemory.getAndAddLong(obj, fieldOffset, 444444L);
        assertEquals(777777777L, prevValue);

        long currentValue = obj.field2;
        assertEquals(777777777L + 444444L, currentValue);
    }

    @Test
    public void casSuccessInt() {
        TestClass obj = new TestClass();
        obj.field1 = 789967868;

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field1");
        boolean cas = ObjectMemory.compareAndSwapInt(obj, fieldOffset, 789967868, 32453);
        assertTrue(cas);

        int value = obj.field1;
        assertEquals(32453, value);
    }

    @Test
    public void casFailureInt() {
        TestClass obj = new TestClass();
        obj.field1 = 212121212;

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field1");
        boolean cas = ObjectMemory.compareAndSwapInt(obj, fieldOffset, 5454545, 78787878);
        assertFalse(cas);

        int value = obj.field1;
        assertEquals(212121212, value);
    }

    @Test
    public void casSuccessLong() {
        TestClass obj = new TestClass();
        obj.field2 = 41414141414141L;

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field2");
        boolean cas = ObjectMemory.compareAndSwapLong(obj, fieldOffset, 41414141414141L, 848484848L);
        assertTrue(cas);

        long value = obj.field2;
        assertEquals(848484848L, value);
    }

    @Test
    public void casFailureLong() {
        TestClass obj = new TestClass();
        obj.field2 = 6464646464646L;

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field2");
        boolean cas = ObjectMemory.compareAndSwapLong(obj, fieldOffset, 234513456L, 46784678L);
        assertFalse(cas);

        long value = obj.field2;
        assertEquals(6464646464646L, value);
    }

    @Test
    public void casSuccessObject() {
        TestClass obj = new TestClass();
        obj.field3 = "bcbcbcbcb";

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field3");
        boolean cas = ObjectMemory.compareAndSwapObject(obj, fieldOffset, "bcbcbcbcb", "wqwqwqwqwqw");
        assertTrue(cas);

        Object value = obj.field3;
        assertEquals("wqwqwqwqwqw", value);
    }

    @Test
    public void casFailureObject() {
        TestClass obj = new TestClass();
        obj.field3 = "iuiuiuiui";

        long fieldOffset = ObjectMemory.fieldOffset(TestClass.class, "field3");
        boolean cas = ObjectMemory.compareAndSwapObject(obj, fieldOffset, "qew45bg245tb", "dfghwse34");
        assertFalse(cas);

        Object value = obj.field3;
        assertEquals("iuiuiuiui", value);
    }

    private class TestClass {

        private int field1;
        private long field2;
        private Object field3;

    }
}
