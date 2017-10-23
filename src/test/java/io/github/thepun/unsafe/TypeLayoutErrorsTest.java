package io.github.thepun.unsafe;

import java.io.Serializable;
import java.util.function.Function;
import java.util.logging.Level;

import org.junit.Test;

public class TypeLayoutErrorsTest {

    @Test(expected = IllegalArgumentException.class)
    public void classInsteadOfArrayForOffset() {
        ArrayMemoryLayout.getElementOffset(Integer.class, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void interfaceInsteadOfArrayForOffset() {
        ArrayMemoryLayout.getElementOffset(Serializable.class, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void classInsteadOfArrayForSize() {
        ArrayMemoryLayout.getElementSize(String.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void interfaceInsteadOfArrayForSize() {
        ArrayMemoryLayout.getElementSize(Function.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void unknownField() {
        ObjectMemoryLayout.getFieldOffset(Integer.class, "asd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayInsteadOfClassForFieldOffset() {
        ObjectMemoryLayout.getFieldOffset(int[].class, "field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void interfaceInsteadOfClassForFieldOffset() {
        ObjectMemoryLayout.getFieldOffset(Runnable.class, "field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void enumInsteadOfClassForFieldOffset() {
        ObjectMemoryLayout.getFieldOffset(Level.class, "field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void primitiveInsteadOfClassForFieldOffset() {
        ObjectMemoryLayout.getFieldOffset(int.class, "field");
    }
}
