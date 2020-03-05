package com.raymond.queue;

/**
 * @author pipi
 * @date 2020-02-25 17:56:48
 */
public class ArrayQueue<E> implements Queue<E> {
    private E[] data;
    private int size;

    /**
     * The constructor of the queue, the default size is 10
     */
    public ArrayQueue() {
        this(10);
    }

    /**
     * The specified size constructor
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * Enqueue the data to the queue
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if (size == data.length) {
            resize();
        }
        data[size] = e;
        size++;
    }


    /**
     * Dequeue from the queue
     *
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty");
        }
        E e = data[0];
        for (int i = 0; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return e;
    }

    /**
     * Get the font data of the queue
     *
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty()) {
            return null;
        }
        return data[size - 1];
    }

    /**
     * Get the size of the queue
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Check the queue is empty or not
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Resize the queue's size to accept more data
     */
    private void resize() {
        E[] newData = (E[]) new Object[size * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Queue : size = %d, capacity = %d\n", size, data.length));
        result.append('[');
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
