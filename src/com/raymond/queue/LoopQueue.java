package com.raymond.queue;

/**
 * Loop Queue
 * To resolve the efficiency problem while dequeue
 *
 * @author pipi
 * @date 2020-02-25 23:19:48
 */
public class LoopQueue<E> implements Queue<E> {
    /** Data container */
    private E[] data;

    /** Queue size */
    private int size;

    /** Front cursor and tail cursor */
    private int front, tail;


    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1]; // Remains one position for the judgement of whether the queue is full
        size = 0;
        front = 0;
        tail = 0;
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            resize();
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("The loop queue is empty");
        }
        E e = data[front];
        data[front] = null; // help gc
        front = (front + 1) % data.length;
        size--;
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new RuntimeException("The loop queue is empty");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * Use this method to judge whether the queue is full
     *
     * @return
     */
    private boolean isFull() {
        return (tail + 1) % data.length == front;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * Resize the queue, notice the old queue's index which should be changed while putting into the new queue.
     * The outbound element should be reindex through mod.
     */
    private void resize() {
        E[] newData = (E[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Loop Queue:");
        result.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            result.append(data[i]);
            if ((i + 1) % data.length != tail) {
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
