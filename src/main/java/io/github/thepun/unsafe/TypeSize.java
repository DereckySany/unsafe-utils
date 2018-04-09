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

public final class TypeSize {

    private static final int INT_SIZE = 4;
    private static final int LONG_SIZE = 8;
    private static final int SHORT_SIZE = 2;
    private static final int CHAR_SIZE = 2;
    private static final int FLOAT_SIZE = 4;
    private static final int DOUBLE_SIZE = 8;

    private static final int REFERENCE_SIZE = UnsafeLocator.getUnsafe().arrayIndexScale(Object[].class);

    public static int ofInt() {
        return INT_SIZE;
    }

    public static int ofLong() {
        return LONG_SIZE;
    }

    public static int ofShort() {
        return SHORT_SIZE;
    }

    public static int ofChar() {
        return CHAR_SIZE;
    }

    public static int ofFloat() {
        return FLOAT_SIZE;
    }

    public static int ofDouble() {
        return DOUBLE_SIZE;
    }

    public static int ofReference() {
        return REFERENCE_SIZE;
    }


    private TypeSize() {
    }
}
