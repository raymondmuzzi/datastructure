package com.raymond.heap;

import java.util.Random;

/**
 * @author raymondmuzzi
 * @date 2020-05-10 18:01:39
 */
public class MaxHeapMain {
    private static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> heap;
        if (isHeapify) {
            heap = new MaxHeap<>(testData);
        }
        else {
            heap = new MaxHeap<>();
            for (Integer data : testData) {
                heap.add(data);
            }
        }

        int[] array = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            array[i] = heap.extractMax();
        }

        // 检查该堆是否为MaxHeap
        for (int i = 1; i < testData.length; i++) {
            if (array[i - 1] < array[i]) {
                throw new RuntimeException("Wrong max heap");
            }
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 1000000;
        Random random = new Random();
        Integer[] testData = new Integer[n];

        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.printf("With heapify time %s s", testHeap(testData, true));
        System.out.println();
        System.out.printf("Without heapify time %s s", testHeap(testData, false));
    }
}