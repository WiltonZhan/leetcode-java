package com.WiltonZhan.leetcode.l206ReverseLinkedList;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head != null) {
            ListNode h = new ListNode(head.val);
            h.next = dummy.next;
            dummy.next = h;
            head = head.next;
        }

        return dummy.next;
    }
}
