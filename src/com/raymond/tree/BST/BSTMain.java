package com.raymond.tree.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author raymondmuzzi
 * @date 2020-05-02 23:05:06
 */
public class BSTMain {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }

        List<Integer> list = new ArrayList<Integer>();

        while (!bst.isEmpty()) {
            list.add(bst.removeMin());
        }

        System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                System.out.println("Problems!!!");
            }
        }
    }
}