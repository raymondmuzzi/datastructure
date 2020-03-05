package com.raymond.linkedlist;

import com.raymond.linkedlist.LinkedList;
import com.raymond.stack.Stack;

/**
 * @author pipi
 * @date 2020-02-29 19:50:07
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> data;

    public LinkedListStack() {
        data = new LinkedList<E>();
    }

    @Override
    public void push(E e) {
        data.addFirst(e);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.getFirst() == null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack: top ");
        result.append(data);
        return result.toString();
    }
}
