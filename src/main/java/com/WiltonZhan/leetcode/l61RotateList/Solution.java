package com.WiltonZhan.leetcode.l61RotateList;

/*
61. 旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
        5    1->2->0->NULL
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     * 我们需要找出分割点的位置。分割点将链表分为前半部分（包含分割点）和后半部分，交换两部分的位置，同时更新两个部分中最后一个节点的指向即可。
     * 假设链表的长度为n。分两种情况讨论：
     *  1. 若 k % n == 0，则直接返回head；
     *  2. 否则，分割点的位置为：n-(k%n)-1，第 n-(k%n) 位置（位置从0开始）的节点将成为旋转后的链表的头节点。
     * 以0->1->2->NULL, k = 4 为例：k % n = 1，旋转后链表的头头节点的值为2。
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        if (k % n == 0) {
            return head;
        }
        int t = n - (k % n) - 1;
        temp = head;
        // 找到分割点
        for (int i = 0; i < t; i++) {
            temp = temp.next;
        }

        ListNode tail1 = temp;
        temp = temp.next;
        // 新的尾
        tail1.next = null;
        // 新的头
        ListNode head1 = temp;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 连接
        temp.next = head;
        head = head1;

        return head;
    }
}
