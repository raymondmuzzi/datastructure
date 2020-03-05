package com.raymond.queue;

/**
 * Based array's Queue
 *
 * @author raymondmuzzi
 * @date 2020-02-25 17:57:03
 */
public class ArrayQueueMain {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Queue queue = new ArrayQueue();
        for (int i = 0; i < 1000000; i++) {
            queue.enqueue("" + i);
            if (i % 3 == 2) {
                // o(n)
                //queue.dequeue();
                // o(1)
                queue.enqueue(1);
                //System.out.println(queue);
            }
        }
        long end = System.currentTimeMillis();
        // When operate 1000000 data, compared the two:
        // o(n) dequeue: 79226ms
        // o(1) enqueue: 138ms
        System.out.println((end - start) + "ms");
    }
}
