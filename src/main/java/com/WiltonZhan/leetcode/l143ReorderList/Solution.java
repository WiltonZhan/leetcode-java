package com.WiltonZhan.leetcode.l143ReorderList;

/*
143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

1->2->3->4->5->6  => 1->6->2->5->3->4
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    /**
     * 将原链表拆分为两个链表，然后逆序第二个链表，再交叉合并。例如：1->2->3->4->5可以拆分为：1->2->3和4->5。
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverseList(head2);

        ListNode cur = dummy, temp = head;
        while (head2 != null) {
            cur.next = temp;
            temp = temp.next;
            cur = cur.next;
            cur.next = head2;
            head2 = head2.next;
            cur = cur.next;
        }
        if (temp != null) {
            cur.next = temp;
        }

        head = dummy.next;
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
}
