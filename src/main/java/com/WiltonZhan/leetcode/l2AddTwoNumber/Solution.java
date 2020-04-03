package com.WiltonZhan.leetcode.l2AddTwoNumber;

class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;
        for(;l1 != null && l2 != null; l1 = l1.next, l2 = l2.next) {
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        while(l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
