package com.WiltonZhan.leetcode.l82RemoveDuplicatesFromSortedListII;

/*
82. 删除排序链表中的重复元素 II
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null || cur.val != cur.next.val) {
                temp.next = cur;
                temp = temp.next;
                cur = cur.next;
                temp.next = null;
            } else {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
            }

        }

        return dummy.next;
    }
}
