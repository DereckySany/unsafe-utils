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

import java.util.logging.Level;

import org.junit.Test;

public class ObjectErrorsTest {

    @Test(expected = IllegalArgumentException.class)
    public void unknownField() {
        ObjectMemory.fieldOffset(Integer.class, "asd");
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayInsteadOfClassForFieldOffset() {
        ObjectMemory.fieldOffset(int[].class, "field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void interfaceInsteadOfClassForFieldOffset() {
        ObjectMemory.fieldOffset(Runnable.class, "field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void enumInsteadOfClassForFieldOffset() {
        ObjectMemory.fieldOffset(Level.class, "field");
    }

    @Test(expected = IllegalArgumentException.class)
    public void primitiveInsteadOfClassForFieldOffset() {
        ObjectMemory.fieldOffset(int.class, "field");
    }
}
