package io.github.thepun.unsafe.chars;

import io.github.thepun.unsafe.OffHeapMemory;

import java.nio.charset.StandardCharsets;

public final class ZeroEndingCharSequence implements CharSequence {

    private long address;
    private int length;

    public ZeroEndingCharSequence() {
        length = 0;
        address = 0;
    }

    public ZeroEndingCharSequence(long address, int maxLnegth) {
        setAddress(address, maxLnegth);
    }

    public void setAddress(long address, int maxLnegth) {
        this.address = address;
        scanForZero(maxLnegth);
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

    private void scanForZero(int maxLnegth) {
        int k = 0;

        long currentAddress = address + maxLnegth;
        for (long i = address; i < currentAddress; i += 1) {
            char c = (char) OffHeapMemory.getByte(i);
            if (c == 0) {
                length = k;
                return;
            }

            k++;
        }

        length = maxLnegth;
    }
}
