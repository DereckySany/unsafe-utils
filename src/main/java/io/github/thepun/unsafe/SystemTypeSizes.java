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
