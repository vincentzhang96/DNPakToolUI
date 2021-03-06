/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Vincent Zhang/PhoenixLAB
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package co.phoenixlab.dn.dnptui.viewers.util;

import java.nio.ByteBuffer;

public class BufferUtils {

    public static void nskip(ByteBuffer byteBuffer, int n, int size) {
        skip(byteBuffer, n * size);
    }

    public static void skip(ByteBuffer byteBuffer, int bytesToSkip) {
        byteBuffer.position(byteBuffer.position() + bytesToSkip);
    }

    public static void iskip(ByteBuffer byteBuffer, int intsToSkip) {
        nskip(byteBuffer, intsToSkip, 4);
    }

    public static void fskip(ByteBuffer byteBuffer, int floatsToSkip) {
        nskip(byteBuffer, floatsToSkip, 4);
    }

    public static void sskip(ByteBuffer byteBuffer, int shortsToSkip) {
        nskip(byteBuffer, shortsToSkip, 2);
    }

    public static void lskip(ByteBuffer byteBuffer, int longsToSkip) {
        nskip(byteBuffer, longsToSkip, 8);
    }

    public static void dskip(ByteBuffer byteBuffer, int doublesToSkip) {
        nskip(byteBuffer, doublesToSkip, 8);
    }
}
