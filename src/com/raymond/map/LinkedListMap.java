package com.raymond.map;

/**
 * @author raymondmuzzi
 * @date 2020-05-05 19:18:32
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        K k;
        V v;
        Node next;

        public Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public Node(K k) {
            this(k, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "k=" + k +
                    ", v=" + v +
                    '}';
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        if (key == null) {
            throw new RuntimeException("Key can not be null");
        }
        Node exist = getNode(key);
        if (exist == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
        else {
            exist.v = value;
        }
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            throw new RuntimeException("Key can not be null");
        }

        Node cur = dummyHead;
        while (cur.next != null) {
            if (key.equals(cur.next.k)) {
                break;
            }
            cur = cur.next;
        }

        if (cur.next != null) {
            Node delNode = cur.next;
            cur.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.v;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        if (key == null) {
            throw new RuntimeException("Key can not be null");
        }
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new RuntimeException("Key can not be null");
        }
        Node node = getNode(key);
        return node == null ? null : node.v;
    }

    @Override
    public void set(K key, V newValue) {
        if (key == null) {
            throw new RuntimeException("Key can not be null");
        }
        Node node = getNode(key);
        if (node != null) {
            node.v = newValue;
        }
        else {
            throw new IllegalArgumentException("No such key : " + key);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /** 根据key获取指定的Node节点 */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (key.equals(cur.k)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
