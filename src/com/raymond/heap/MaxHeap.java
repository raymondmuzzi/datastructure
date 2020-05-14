package com.raymond.heap;

import com.raymond.array.Array;

/**
 * @author raymondmuzzi
 * @date 2020-05-08 23:04:36
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] array) {
        data = new Array<>(array);
        heapify(array);
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /** 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引 */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    /** 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引 */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /** 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引 */
    private int rightChild(int index) {
        return (index + 1) * 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /** 添加元素时，上浮大数据 */
    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            E temp = data.get(parent(index));
            data.set(parent(index), data.get(index));
            data.set(index, temp);
            index = parent(index);
        }
    }

    /** 取出堆中最大的元素 */
    public E extractMax() {
        E result = findMax();
        data.set(0, data.get(size() - 1));
        data.removeLast();
        siftDown(0);
        return result;
    }

    /** 查看堆中最大元素 */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new RuntimeException("Heap is empty, no max value");
        }
        return data.get(0);
    }

    /** 移除元素时，下沉小数据 */
    private void siftDown(int index) {
        while (leftChild(index) < data.getSize()) {
            int maxValIndex = leftChild(index); // 假设最大值的索引maxIndex为左孩子的索引
            int rightIndex = maxValIndex + 1;
            if (rightIndex < data.getSize() &&
                    data.get(rightIndex).compareTo(data.get(maxValIndex)) > 0) {
                maxValIndex = rightIndex;
            }

            if (data.get(index).compareTo(data.get(maxValIndex)) >= 0) {
                break;
            }

            // 交换index和maxValIndex位置上的数据
            E temp = data.get(index);
            data.set(index, data.get(maxValIndex));
            data.set(maxValIndex, temp);
            index = maxValIndex;
        }
    }

    /** 取出堆中最大元素，并且替换成元素e；并返回堆顶元素 */
    public E replace(E e) {
        E result = findMax();
        data.set(0, e);
        siftDown(0);
        return result;
    }

    /** 将数组进行堆化 */
    private void heapify(E[] array) {
        for (int i = parent(array.length - 1); i >= 0; i--) {
            siftDown(i); // 对第i个元素进行下沉操作
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Heap:[");
        for (int i = 0; i < data.getSize(); i++) {
            if (i != data.getSize() - 1) {
                result.append(i).append(", ");
            }
            else {
                result.append(i);
            }
        }
        result.append("]");
        return result.toString();
    }
}
