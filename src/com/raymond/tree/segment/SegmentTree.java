package com.raymond.tree.segment;

import com.sun.tools.doclets.internal.toolkit.taglets.InheritDocTaglet;

/**
 * @author raymondmuzzi
 * @date 2020-05-12 22:56:10
 */
public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] array, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        tree = (E[]) new Object[4 * array.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /** 在treeIndex的位置，创建表示区间[l...r]的线段树 */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftChildIndex, l, mid);
        buildSegmentTree(rightChildIndex, mid + 1, r);

        // 对左孩子和右孩子进行操作，取决于业务需求
        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    public int size() {
        return data.length;
    }

    /** 返回完全二叉树的数组表示中，一个索引所表示的左孩子节点的索引 */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /** 返回完全二叉树的数组表示中，一个索引所代表的右孩子节点的索引 */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /** 返回区间[queryL, queryR]的值 */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /** 在以treeID为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值 */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        }
        else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    /** 将index位置的值，更新为e */
    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /** 在以treeIndex为根的线段树中更新index的值为e */
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (l - r) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        }
        // index <= mid
        else {
            set(leftTreeIndex, l, mid, index, e);
        }
        // 对父节点的情况也需要进行修改
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                result.append(tree[i]).append(",");
            }
            else {
                result.append("null").append(",");
            }
        }
        result.append("]");
        return result.toString();
    }
}
