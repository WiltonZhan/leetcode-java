package com.WiltonZhan.leetcode.l24SwapNodesInPairs;

/*
24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode first = head, second = head.next, cur = dummy;
        while (first != null && second != null) {
            first.next = null;
            cur.next = second;
            cur = cur.next;
            ListNode temp = second.next;
            second.next = null;
            cur.next = first;
            cur = cur.next;
            first = temp;
            second = first != null ? first.next : null;
        }
        if (first != null) {
            cur.next = first;
        }

        return dummy.next;
    }
}
