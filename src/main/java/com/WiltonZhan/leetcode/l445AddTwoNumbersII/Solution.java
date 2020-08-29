package com.WiltonZhan.leetcode.l445AddTwoNumbersII;

/*
445. 两数相加 II
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。



进阶：

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。



示例：

输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     * 第2题与第206题的结合：先用206题的方法反转两个链表，然后用第2题中的方法求和，然后再反转
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = addTwoNumbersR(reverseList(l1), reverseList(l2));
        return reverseList(head);
    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head != null) {
            ListNode h = new ListNode(head.val);
            h.next = dummy.next;
            dummy.next = h;
            head = head.next;
        }

        return dummy.next;
    }


    public ListNode addTwoNumbersR(ListNode l1, ListNode l2) {
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
