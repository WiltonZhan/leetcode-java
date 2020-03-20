package com.WiltonZhan.leetcode.l19RemoveNthNodeFromEndOfList;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     *  两次扫描
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tempNode = dummy;
        while(tempNode.next != null) {
            tempNode = tempNode.next;
            len++;
        }
        tempNode = dummy;
        int preNodeIndex = len - n - 1;
        while(preNodeIndex > 0 && tempNode.next != null) {
            tempNode = tempNode.next;
            preNodeIndex--;
        }
        if (tempNode.next != null) {
            tempNode.next = tempNode.next.next;
        }
        return dummy.next;
    }

    /**
     *  单次扫描
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = dummy, right = dummy;
        while(n-- > 0) {
            right = right.next;
        }
        while(right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
