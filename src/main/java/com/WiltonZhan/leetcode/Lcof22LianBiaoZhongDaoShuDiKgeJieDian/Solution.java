package com.WiltonZhan.leetcode.Lcof22LianBiaoZhongDaoShuDiKgeJieDian;

/*
剑指 Offer 22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。



示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     *  双指针。维护两个指针l和r，先移动r指针使得r领先l (k-1)个节点。然后同步移动l和r，当r指向链表中最后一个节点时，l指向的就是链表中倒数第k个节点。
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode l = head, r = head;
        while (k > 1) {
            if (r == null) {
                throw new IllegalArgumentException();
            }
            r = r.next;
            k--;
        }

        while (r.next != null) {
            r = r.next;
            l = l.next;
        }

        return l;
    }
}
