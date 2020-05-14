package com.raymond.heap;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author raymondmuzzi
 * @date 2020-05-10 21:56:49
 */
public class LeetCode347 {

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return 1;
            else if (this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if (queue.getSize() < k)
                queue.enqueue(new Freq(key, map.get(key)));
            else if (map.get(key) > queue.getFront().freq) {
                queue.dequeue();
                queue.enqueue(new Freq(key, map.get(key)));
            }
        }

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = queue.dequeue().e;
        }
        return arr;
    }
}
