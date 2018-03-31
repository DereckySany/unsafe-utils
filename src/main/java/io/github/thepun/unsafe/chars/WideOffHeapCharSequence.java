package io.github.thepun.unsafe.chars;

import io.github.thepun.unsafe.OffHeapMemory;
import io.github.thepun.unsafe.TypeSize;

public final class WideOffHeapCharSequence implements CharSequence {

    private long address;
    private int length;

    public WideOffHeapCharSequence() {
        this(0,0);
    }

    public WideOffHeapCharSequence(long address, int length) {
        setAddress(address, length);
    }

    public void setAddress(long address, int length) {
        this.address = address;
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public char charAt(int index) {
        return OffHeapMemory.getChar(address + index * TypeSize.ofChar());
    }

    @Override
    public WideOffHeapCharSequence subSequence(int start, int end) {
        return new WideOffHeapCharSequence(address + start * TypeSize.ofChar(), end - start);
    }

    @Override
    public String toString() {
        char[] chars = new char[length];
        OffHeapMemory.copyToArray(address, chars);
        return new String(chars);
    }
}
