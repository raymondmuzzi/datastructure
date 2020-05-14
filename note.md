# Data Structure

## Abstract
Data structure is the sepcialized compulsory course for CS.

Data structure is the study of how data is organized and stored in computer. To learn this course, we can know how to retrive and modify data efficiently.

| Linear Structure                            | Tree Structure                                               | Graphic Structure |
| ------------------------------------------- | ------------------------------------------------------------ | ----------------- |
| Array；Stack；Queue；Linked List；Hashtable | Binary tree；Binary Search Tree；AVL；Red-black Tree；Treap；Splay；Heap；Trie；Segment Tree；K-D Tree；Union-find Set；Huffman Tree | Adjacent Matrix；Adjacent List  |



## Self-check-practice

- Array
- Stack
- LeetCode(20)
- Queue
- Loop Queue
- LinkedList
- LinkedList(use dummy head)
- LinkedList(Stack,Queue)
- LeetCode(203)
- Accomplish linked list via recursive
- Doubly linked list
- Doubly loop linked list(JDK based it)
- Array linked list
- Constructs a BST (add,contains,remove)


## Recursive
We can split the recursive problem into two parts:
- the basic problem
- transforms the original problem into smaller problem

## Binary Search Tree (BST)

Binary search tree is a binary tree.
Every node in binary search tree, its value is larger than all left
tree nodes' value and smaller than all right tree nodes' value.

Every child tree is also the binary search tree.

BST's in-order recursive traversing will arrange all the element in order

In-order non-recursive iteration practice

Iterate the BST via layer, i.e. level-order iterate, which will be functional while finding one element

## Priority Queue

Priority Queue: Enqueue and dequeue sequence determined by the priority

The queue will change dynamically with the data's changing

We can use heap to achieve priority queue, the enqueue and dequeue's time complexity are both log(n)

Binary heap is a complete binary tree. In binary heap, one node value is smaller or equals than its parent's node value

We can use array to represent a heap:
    parent(i) = (i - 1) / 2; 
    left child(i) = 2 * i + 1; 
    right child(i) = 2 * i + 2;

## Segment Tree
Segment Tree is not full binary tree or complete tree.

But segment tree is balanced binary tree. Heap is also balanced binary tree.

Segment tree's last layer and full layer's distance is at most 1.

Still, we can use array to represent the segment tree.Also, we can regard the segment tree as full binary tree
because in the last layer of tree, we can use null to represent the non-exists node. 

As for full binary tree, the h-depth tree has 2^h-1 nodes totally.And the last layer has 2^(h-1) nodes.
So, the last layer node's count roughly equals the previous node's total count.
 
If the data block has n elements, we should construct the 4n size array.

Search and update operation in Segment Tree are both O(logn)

## Trie







