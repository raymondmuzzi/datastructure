package com.raymond.queue;

import com.raymond.linkedlist.LinkedListQueue;

import java.util.Random;

/**
 * @author raymondmuzzi
 * @date 2020-02-28 17:12:11
 */
public class TestMain {
    /**
     * Test the speed difference between array queue and loop queue.
     *
     * @param queue
     * @param operationCount
     * @return
     */
    private static double testQueue(Queue<Integer> queue, int operationCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < operationCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < operationCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 1000000;

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        double time = testQueue(queue, count);
        System.out.println("Array Queue, time:" + time + "s");

        LoopQueue<Integer> queue1 = new LoopQueue<>();
        double time2 = testQueue(queue1, count);
        System.out.println("Loop Queue, time:" + time2 + "s");

        LinkedListQueue<Integer> queue2 = new LinkedListQueue<>();
        double time3 = testQueue(queue2, count);
        System.out.println("LinkedList Queue, time:" + time3 + "s");
    }
}
