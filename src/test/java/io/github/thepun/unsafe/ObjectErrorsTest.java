package io.github.thepun.unsafe;

import java.util.logging.Level;

import org.junit.Test;

public class ObjectErrorsTest {

    @Test(expected = IllegalArgumentException.class)
    public void unknownField() {
        ObjectMemory.fieldOffset(Integer.class, "asd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayInsteadOfClassForFieldOffset() {
        ObjectMemory.fieldOffset(int[].class, "field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void interfaceInsteadOfClassForFieldOffset() {
        ObjectMemory.fieldOffset(Runnable.class, "field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void enumInsteadOfClassForFieldOffset() {
        ObjectMemory.fieldOffset(Level.class, "field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void primitiveInsteadOfClassForFieldOffset() {
        ObjectMemory.fieldOffset(int.class, "field");
    }
}
