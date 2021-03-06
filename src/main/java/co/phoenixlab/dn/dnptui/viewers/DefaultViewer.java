/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Vincent Zhang/PhoenixLAB
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

package co.phoenixlab.dn.dnptui.viewers;

import co.phoenixlab.dn.dnptui.PakTreeEntry;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;

import java.nio.ByteBuffer;

public class DefaultViewer implements Viewer {

    private boolean isDirectory;
    private boolean isBlank;
    private int children;

    private final Group EMPTY_GROUP;
    private final Label NO_ITEM_SELECTED;
    private final Label CANT_DECODE;

    public DefaultViewer() {
        EMPTY_GROUP = new Group();
        NO_ITEM_SELECTED = new Label("No file selected");
        CANT_DECODE = new Label("No decoder registered for file. Export this file to view in another editor.");
    }

    @Override
    public Node getDisplayNode() {
        if (isBlank) {
            return NO_ITEM_SELECTED;
        } else {
            if (isDirectory) {
                //  TODO
                return new Label(String.format("%,d children", children));
            } else {
                //  TODO
                return CANT_DECODE;
            }
        }
    }

    private int countChildren(TreeItem<PakTreeEntry> entry) {
        int counter = 0;
        for (TreeItem<PakTreeEntry> child : entry.getChildren()) {
            ++counter;
            counter += countChildren(child);
        }
        return counter;
    }

    @Override
    public void parse(ByteBuffer byteBuffer) {

    }

    @Override
    public void onLoadStart(TreeItem<PakTreeEntry> pakTreeEntry) {
        isBlank = pakTreeEntry == null || pakTreeEntry.getValue() == null;
        isDirectory = !isBlank && pakTreeEntry.getValue().isDirectory();
        children = countChildren(pakTreeEntry);
    }

    @Override
    public void reset() {

    }
}
