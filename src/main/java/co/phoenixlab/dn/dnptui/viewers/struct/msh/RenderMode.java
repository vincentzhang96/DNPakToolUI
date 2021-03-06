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

package co.phoenixlab.dn.dnptui.viewers.struct.msh;

import java.util.function.IntUnaryOperator;

public enum RenderMode {
    TRIANGLES(0, i -> i / 3),
    TRIANGLE_STRIP(1, i -> i - 2),
    TRIANGLES_ANIM(256, i -> i / 3),
    TRIANGLE_STRIP_ANIM(257, i -> i - 2),
    TRIANGLES_UNK(65536, i -> i / 3),
    TRIANGLE_STRIP_UNK(65537, i -> i - 2),
    UNKNOWN(-1, i -> i / 3);


    private int id;
    private IntUnaryOperator faceCountConverter;

    RenderMode(int id, IntUnaryOperator faceCountConverter) {
        this.id = id;
        this.faceCountConverter = faceCountConverter;
    }

    public static RenderMode fromId(int id) {
        for (RenderMode renderMode : values()) {
            if (renderMode.id == id) {
                return renderMode;
            }
        }
        return UNKNOWN;
    }

    public int getId() {
        return id;
    }

    public IntUnaryOperator getFaceCountConverter() {
        return faceCountConverter;
    }
}
