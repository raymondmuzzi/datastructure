package com.raymond.recursive;

/**
 * @author pipi
 * @date 2020-03-05 17:50:59
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("The array should not be empty");
        }
        ListNode cur = this;
        this.val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            cur.next = newNode;
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val);
            res.append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();

    }
}

/**
 * The best solution for LeetCode203.
 * A great practice example for recursive
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode node = removeElements(head.next, val);
        if (head.val == val) {
            return node;
        } else {
            head.next = node;
            return head;
        }
    }
}

public class LeetCode203Recursive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 5, 6};
        ListNode head = new ListNode(arr);
        System.out.println(head);
        ListNode listNode = new Solution().removeElements(head, 6);
        System.out.println(listNode);
    }
}
