package com.raymond.map;

import com.raymond.set.FileOperation;

import java.util.ArrayList;

/**
 * @author raymondmuzzi
 * @date 2020-05-05 20:35:10
 */
public class MapMain {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("/Users/mac/IdeaProjects/play-with-data-structure/src/pride-and-prejudice.txt", list);

//        BSTMap<String, Integer> map = new BSTMap<>();
        LinkedListMap<String, Integer> map = new LinkedListMap<>();

        for (String word : list) {
            Integer integer = map.get(word);
            if (integer == null) {
                integer = 1;
            }
            else {
                integer++;
            }
            map.add(word, integer);
        }

        System.out.println(map.get("pride"));
        System.out.println(map.get("prejudice"));

    }
}
