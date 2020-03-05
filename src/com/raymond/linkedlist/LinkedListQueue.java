package com.raymond.linkedlist;

import com.raymond.queue.Queue;

/**
 * @author pipi
 * @date 2020-02-29 22:36:09
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node<E> {
        private E e;
        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node<E> head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node<>(e);
            head = tail;
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot dequeue from an empty queue.");
        }
        if (head == tail) {
            E result = head.e;
            head = tail = null;
            size--;
            return result;
        } else {
            Node<E> temp = head;
            E result = temp.e;
            head = head.next;
            temp.next = null; // help gc
            size--;
            return result;
        }
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue: front [");

        Node cur = head;
        while (cur != null) {
            result.append(cur.e + "->");
            cur = cur.next;
        }
        result.append("NULL ] tail");
        return result.toString();
    }
}
