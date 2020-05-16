package com.raymond.tree.trie;

import java.util.TreeMap;

/**
 * @author raymondmuzzi
 * @date 2020-05-13 23:50:33
 */
public class Trie {
    private class Node{
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
    }
}
