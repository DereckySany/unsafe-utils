package io.github.thepun.unsafe;

import sun.misc.Unsafe;

public class SystemTypeSizes {

    private static final int INT_SIZE;
    private static final int LONG_SIZE;
    private static final int SHORT_SIZE;
    private static final int CHAR_SIZE;
    private static final int REFERENCE_SIZE;
    static {
        Unsafe unsafe = UnsafeLocator.getUnsafe();
        INT_SIZE = unsafe.arrayIndexScale(int[].class);
        LONG_SIZE = unsafe.arrayIndexScale(long[].class);
        SHORT_SIZE = unsafe.arrayIndexScale(short[].class);
        CHAR_SIZE = unsafe.arrayIndexScale(char[].class);
        REFERENCE_SIZE = unsafe.arrayIndexScale(Object[].class);
    }

    public static int intSize() {
        return INT_SIZE;
    }

    public static int longSize() {
        return LONG_SIZE;
    }

    public static int charSize() {
        return CHAR_SIZE;
    }

    public static int shortSize() {
        return SHORT_SIZE;
    }

    public static int referenceSize() {
        return REFERENCE_SIZE;
    }


    private SystemTypeSizes() {
    }
}
