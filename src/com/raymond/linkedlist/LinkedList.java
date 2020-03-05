package com.raymond.linkedlist;

/**
 * @author raymondmuzzi
 * @date 2020-02-28 20:49:20
 */
public class LinkedList<E> {
    /**
     * Access in the LinkedList class only
     */
    private class Node<E> {
        public E e;
        public Node<E> next;

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

    /** The dummy head of the linked list, of no sense */
    private Node<E> dummyHead;

    /** The size of the linked list */
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add the element in the specific index
     *
     * @param index index of the data inserted
     * @param e     the element needed to be inserted
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        Node prev = dummyHead;
        Node node = new Node(e);

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        node.next = prev.next;
        prev.next = node;
        size++;
    }

    /**
     * Add new element to the head
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Add the element at the end of the linked list
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * Get the element of the specific element
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Get failed. Out of bound");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * Get the first element of the linked list
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * Get the last element of the linked list
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * Update the element in specific index
     *
     * @param index
     * @param e
     */
    public void update(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Update failed. Out of bound");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * Judge if the e element exists in the linked list
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        if (isEmpty()) {
            return false;
        }
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * Remove the specific index's element
     *
     * @param index
     * @return Return the removed element
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Remove failed. Out of bound");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        Node<E> delNode = cur.next; // mark the removed node
        cur.next = cur.next.next;
        delNode.next = null; // help gc
        size--;
        return delNode.e;
    }

    /**
     * Remove the first element from the linked list
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Remove the last element from the linked list
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("LinkedList:[");
        Node cur = dummyHead.next;
        while (cur != null) {
            result.append(cur.e + "->");
            cur = cur.next;
        }
        result.append("NULL]");
        return result.toString();
    }
}
