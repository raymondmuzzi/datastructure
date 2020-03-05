package com.raymond.linkedlist;

/**
 * @author pipi
 * @date 2020-02-29 14:34:41
 */
public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0, 1);
        linkedList.add(1, 2);
        linkedList.add(2, 3);
        linkedList.add(3, 4);

        System.out.println(linkedList);
        linkedList.update(2, 4);
        System.out.println(linkedList);
        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);

    }
}
