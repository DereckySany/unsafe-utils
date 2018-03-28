package io.github.thepun.unsafe.chars;

import io.github.thepun.unsafe.OffHeapMemory;

import java.nio.charset.StandardCharsets;

public final class AsciiOffHeapCharSequence implements CharSequence {

    private long address;
    private int length;

    public AsciiOffHeapCharSequence() {
        this(0,0);
    }

    public AsciiOffHeapCharSequence(long address, int length) {
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
    public AsciiOffHeapCharSequence subSequence(int start, int end) {
        return new AsciiOffHeapCharSequence(address + start, end - start);
    }

    @Override
    public String toString() {
        byte[] bytes = new byte[length];
        OffHeapMemory.copyToArray(address, bytes);
        return new String(bytes, StandardCharsets.US_ASCII);
    }
}
