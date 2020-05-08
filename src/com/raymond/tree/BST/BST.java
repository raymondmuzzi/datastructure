package com.raymond.tree.BST;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author raymondmuzzi
 * @date 2020-05-02 22:51:19
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /** 非递归方式添加元素 */
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
        }
        else {
            Node cur = root;
            Node prev = root;
            while (cur != null) {
                prev = cur;
                if (e.compareTo(cur.e) < 0) {
                    cur = cur.left;
                }
                else if (e.compareTo(cur.e) > 0) {
                    cur = cur.right;
                }
                else {
                    return;
                }
            }

            if (e.compareTo(prev.e) > 0) {
                prev.right = new Node(e);
            }
            else if (e.compareTo(prev.e) < 0) {
                prev.left = new Node(e);
            }
        }
        size++;
    }

    /** 递归方式添加元素 */
    public void addRecursive(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        }
        else {
            addRecursive(root, e);
        }
    }

    /** 向以node为根的二分搜索树中插入元素e，递归算法 */
    private void addRecursive(Node node, E e) {
        if (node.e.equals(e)) {
            return;
        }
        else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }
        else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            addRecursive(node.left, e);
        }
        else {
            addRecursive(node.right, e);
        }
    }

    /** 增强版的递归添加元素方法，当root节点为null时，直接设置跟节点的值 */
    public void addRecursiveImproved(E e) {
        root = addRecursiveImproved(root, e);
    }

    /** 返回插入新节点后二分搜索树的根 */
    private Node addRecursiveImproved(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = addRecursiveImproved(node.left, e);
        }
        else if (e.compareTo(node.e) > 0) {
            node.right = addRecursiveImproved(node.right, e);
        }
        return node;
    }

    /** 查看二分搜索树中是否存在元素e */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e == e) {
            return true;
        }
        else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        else {
            return contains(node.right, e);
        }
    }

    /** 前序遍历 */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    /** 中序遍历 */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    /** 后序遍历 */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }

    /** 非递归的方式进行前序遍历 */
    public void preOrderNonRecursive() {
        System.out.print("非递归方式前序遍历：");
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            System.out.print(top.e + " ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    /** 按层遍历BST */
    public void levelOrder() {
        System.out.print("按层遍历：");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            System.out.print(front.e + " ");
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    /** 查询最小值节点 */
    public E minimum() {
        if (isEmpty()) {
            throw new RuntimeException("BST is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /** 查询最大值节点 */
    public E maximum() {
        if (isEmpty()) {
            throw new RuntimeException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /** 从二分搜索树中删除最小值所在节点，并返回最小值 */
    public E removeMin() {
        E result = minimum();
        root = removeMin(root);
        return result;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /** 从二分搜索树中删除最大值所在节点，并返回最大值 */
    public E removeMax() {
        E result = maximum();
        root = removeMax(root);
        return result;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 1962年，Hibbard提出的：Hibbard Deletion
     * 从BST中删除元素为e的节点
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归算法
     * 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        else { // e.compareTo(node.e) == 0
            // 待删除左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            /*
             * 待删除子树的左右子树均不为空的情况
             *
             * 找到比待删除节点大的最小节点，即删除节点右子树的最小节点
             * 用这个节点顶替待删除节点的位置
             */
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

}
