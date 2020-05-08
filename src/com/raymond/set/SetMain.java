package com.raymond.set;

/**
 * @author raymondmuzzi
 * @date 2020-05-05 13:48:30
 */
public class SetMain {
    public static void main(String[] args) {
        Set<String> bstSet = new BSTSet<>();
        long start = System.currentTimeMillis();
        FileOperation.readFile("/Users/mac/IdeaProjects/play-with-data-structure/src/pride-and-prejudice.txt", bstSet);
        long end = System.currentTimeMillis();
        System.out.printf("bstSet : %dms\n", (end - start));

        Set<String> linkedListSet = new LinkedListSet<>();
        start = System.currentTimeMillis();
        FileOperation.readFile("/Users/mac/IdeaProjects/play-with-data-structure/src/pride-and-prejudice.txt", linkedListSet);
        end = System.currentTimeMillis();
        System.out.printf("linkedListSet : %dms\n", (end - start));
    }
}
