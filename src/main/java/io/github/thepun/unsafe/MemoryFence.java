package io.github.thepun.unsafe;

/**
 * Utility class for placing memory barriers
 */
public final class MemoryFence {

    /**
     * LoadLoad/LoadStore memory barrier
     */
    public static void load() {
        UnsafeLocator.getUnsafe().loadFence();
    }

    /**
     * LoadStore/StoreStore memory barrier
     */
    public static void store() {
        UnsafeLocator.getUnsafe().storeFence();
    }

    /**
     * Full memory barrier
     */
    public static void full() {
        UnsafeLocator.getUnsafe().fullFence();
    }


    private MemoryFence() {
    }
}
