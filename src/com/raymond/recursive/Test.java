package com.raymond.recursive;

/**
 * @author raymondmuzzi
 * @date 2020-03-05 22:50:58
 */
public class Test {
    public static void main(String[] args) {
        LinkedListRecursive<Object> linkedList = new LinkedListRecursive<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);

        linkedList.addLast(4);
        linkedList.addLast(3);
        linkedList.addLast(2);
        linkedList.addLast(1);
        System.out.println(linkedList);
        linkedList.remove(0);
        System.out.println(linkedList);
        linkedList.remove(1);
        System.out.println(linkedList);
        linkedList.remove(linkedList.getSize()-1);
        System.out.println(linkedList);
    }
}
