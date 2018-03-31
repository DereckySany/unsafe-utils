/**
 * Copyright (C)2011 - Marat Gariev <thepun599@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
