package com.raymond.queue;

/**
 * @author raymondmuzzi
 * @date 2020-02-25 23:46:05
 */
public class LoopQueueMain{
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Queue queue = new LoopQueue();
        for (int i = 0; i < 1000000; i++) {
            queue.enqueue("" + i);
            if (i % 3 == 2) {
                // o(1)
                queue.dequeue();
                // o(1)
                // queue.enqueue(1);
                //System.out.println(queue);
            }
        }
        long end = System.currentTimeMillis();
        // When operate 1000000 data, compared the two:
        // o(1) dequeue: 127ms compared with the array queue, the loop queue's dequeue time complexity is o(1). Much faster than the array queue
        // o(1) enqueue: 138ms
        System.out.println((end - start) + "ms");
    }
}
