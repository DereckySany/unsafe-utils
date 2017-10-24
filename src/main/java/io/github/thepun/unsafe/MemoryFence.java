package io.github.thepun.unsafe;

import sun.misc.Unsafe;

/**
 * Utility class for placing memory barriers
 */
public final class MemoryFence {

    private static final Unsafe UNSAFE_INSTANCE = UnsafeLocator.getUnsafe();

    /**
     * LoadLoad/LoadStore memory barrier
     */
    public static void load() {
        UNSAFE_INSTANCE.loadFence();
    }

    /**
     * LoadStore/StoreStore memory barrier
     */
    public static void store() {
        UNSAFE_INSTANCE.storeFence();
    }

    /**
     * Full memory barrier
     */
    public static void full() {
        UNSAFE_INSTANCE.fullFence();
    }


    private MemoryFence() {
    }
}
