package io.github.thepun.unsafe.chars;

import io.github.thepun.unsafe.OffHeapMemory;
import io.github.thepun.unsafe.TypeSize;

public final class Utf16ZeroEndingCharSequence implements CharSequence {

    private long address;
    private int length;

    public Utf16ZeroEndingCharSequence() {
        length = 0;
        address = 0;
    }

    public Utf16ZeroEndingCharSequence(long address, int maxLnegth) {
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
        return OffHeapMemory.getChar(address + index * TypeSize.ofChar());
    }

    @Override
    public Utf16OffHeapCharSequence subSequence(int start, int end) {
        return new Utf16OffHeapCharSequence(address + start * TypeSize.ofChar(), end - start);
    }

    @Override
    public String toString() {
        char[] chars = new char[length];
        OffHeapMemory.copyToArray(address, chars);
        return new String(chars);
    }

    private void scanForZero(int maxLnegth) {
        int k = 0;

        long maxAddress = address + maxLnegth * TypeSize.ofChar();
        for (long i = address; i < maxAddress; i += TypeSize.ofChar()) {
            char c = OffHeapMemory.getChar(i);
            if (c == 0) {
                length = k;
                return;
            }

            k++;
        }

        length = maxLnegth;
    }
}
