package com.raymond.linkedlist;

import com.raymond.stack.ArrayStack;
import com.raymond.stack.Stack;

import java.util.Random;

/**
 * @author pipi
 * @date 2020-02-29 20:14:12
 */
public class LinkedListStackMain {

    private static double testStack(Stack<Integer> stack, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }


        for (int i = 0; i < count; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 10000000;

        LinkedListStack<Integer> stack1 = new LinkedListStack<>();
        double time1 = testStack(stack1, count);
        System.out.println("ArrayStack, time:" + time1 + " s");

        ArrayStack<Integer> stack2 = new ArrayStack<>();
        double time2 = testStack(stack2, count);
        System.out.println("LinkedListStack, time:" + time2 + " s");

    }
}
