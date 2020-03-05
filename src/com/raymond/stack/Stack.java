package com.raymond.stack;

/**
 * @author raymondmuzzi
 * @date 2020-02-24 00:27:47
 */
public interface Stack<E> {
    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
