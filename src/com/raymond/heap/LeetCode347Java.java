package com.raymond.heap;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.PriorityQueue;

/**
 * @author raymondmuzzi
 * @date 2020-05-10 21:56:49
 */
public class LeetCode347Java {

    private class Freq implements Comparable<Freq> {
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq > another.freq)
                return 1;
            else if (this.freq < another.freq)
                return -1;
            else
                return 0;
        }
    }

    /** 自定义的比较器，可以对字符串等Java内置的类[比如：String]的比较方式进行修改 */
    private class FreqComparator implements Comparator<Freq> {
        @Override
        public int compare(Freq o1, Freq o2) {
            return o1.freq - o2.freq;
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

        PriorityQueue<Freq> queue = new PriorityQueue<>(new FreqComparator());
        for (Integer key : map.keySet()) {
            if (queue.size() < k)
                queue.add(new Freq(key, map.get(key)));
            else if (map.get(key) > queue.peek().freq) {
                queue.remove();
                queue.add(new Freq(key, map.get(key)));
            }
        }

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = queue.remove().e;
        }
        return arr;
    }
}
