package com.raymond.stack;

/**
 * @author raymondmuzzi
 * @date 2020-02-23 23:45:07
 */
public class ArrayStack<E> implements Stack<E> {
    private E[] data;
    private int size;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 向栈顶添加一个元素
     *
     * @param e
     */
    public void push(E e) {
        if (size == data.length) {
            resize();
        }
        data[size] = e;
        size++;
    }

    /**
     * 弹出栈顶元素
     *
     * @return
     */
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        E result = data[size - 1];
        data[size - 1] = null;
        size--;
        return result;
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty");
        }
        return data[size - 1];
    }

    /**
     * 获取栈的大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 对栈进行重新扩容
     */
    private void resize() {
        E[] newData = (E[]) new Object[size * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Stack: size = %d, capacity = %d\n", size, data.length));
        result.append('[');
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append("] top");
        return result.toString();
    }
}