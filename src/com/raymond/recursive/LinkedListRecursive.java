package com.raymond.recursive;

/**
 * @author raymondmuzzi
 * @date 2020-03-05 22:27:23
 */
public class LinkedListRecursive<E> {
    private Node<E> head;
    private int size;

    public LinkedListRecursive() {
        head = new Node<E>(null);
        size = 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Index out of bounds");
        }
        Node cur = head;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        if (index == 0) {
            Node<E> eNode = new Node<>(e);
            Node temp = head.next;
            head.next = eNode;
            eNode.next = temp;
        } else {
            Node<E> eNode = new Node<>(e);
            Node temp = cur;
            cur.next = eNode;
            eNode.next = temp.next;
        }
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Out of bounds");
        }
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node<E> res = cur.next;
        if (cur.next != null) {
            cur.next = cur.next.next;
        }

        size--;

        return res.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean contains(E e) {
        return false;
    }

    public void update(int index, E e) {

    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node<E> cur = head.next;
        for (int i = 0; i < size; i++) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}

class Node<E> {
    E e;
    Node next;

    public Node(E e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return e.toString();
    }
}

