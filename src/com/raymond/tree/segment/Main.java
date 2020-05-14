package com.raymond.tree.segment;

/**
 * @author raymondmuzzi
 * @date 2020-05-13 01:13:33
 */
public class Main {
    public static void main(String[] args) {
        Integer[] array = {2, 5, 1, 6, 3, 9, 4};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(array, (e1, e2) -> e1 + e2);
        System.out.println(segmentTree);
    }
}
