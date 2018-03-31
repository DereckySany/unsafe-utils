package io.github.thepun.unsafe.chars;

import io.github.thepun.unsafe.OffHeapMemory;

import java.nio.charset.StandardCharsets;

public final class OffHeapCharSequence implements CharSequence {

    private long address;
    private int length;

    public OffHeapCharSequence() {
        this(0,0);
    }

    public OffHeapCharSequence(long address, int length) {
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
        return (char) OffHeapMemory.getByte(address + index);
    }

    @Override
    public OffHeapCharSequence subSequence(int start, int end) {
        return new OffHeapCharSequence(address + start, end - start);
    }

    @Override
    public String toString() {
        byte[] bytes = new byte[length];
        OffHeapMemory.copyToArray(address, bytes);
        return new String(bytes, StandardCharsets.US_ASCII);
    }
}
