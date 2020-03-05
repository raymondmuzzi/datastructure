package com.raymond.stack;

/**
 * @author pipi
 * @date 2020-02-23 23:53:12
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> objectArrayStack = new ArrayStack<>();

        for (int i = 0; i < 1000; i++) {
            objectArrayStack.push(i);
        }

        for (int i = 0; i < 999; i++) {
            objectArrayStack.peek();
        }

        for (int i = 0; i < 990; i++) {
            objectArrayStack.pop();
        }

        System.out.println(objectArrayStack);
        System.out.println(objectArrayStack.isEmpty());
        for (int i = 0; i < 10; i++) {
            objectArrayStack.pop();
        }
        System.out.println(objectArrayStack);
        System.out.println(objectArrayStack.isEmpty());
    }
}
