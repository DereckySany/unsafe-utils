package org.thepun.unsafe;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class UnsafeUtils {

    private static final Unsafe INSTANCE;
    static {
        try {
            Field singleoneInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singleoneInstanceField.setAccessible(true);
            INSTANCE = (Unsafe) singleoneInstanceField.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Unsafe getUnsafe() {
        return INSTANCE;
    }

}
