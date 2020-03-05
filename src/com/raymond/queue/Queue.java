package com.raymond.queue;

/**
 * @author raymondmuzzi
 * @date 2020-02-25 17:54:12
 */
public interface Queue<E> {
    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
