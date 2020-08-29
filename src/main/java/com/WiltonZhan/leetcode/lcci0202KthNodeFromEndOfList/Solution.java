package com.WiltonZhan.leetcode.lcci0202KthNodeFromEndOfList;

/*
面试题 02.02. 返回倒数第 k 个节点
实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。

注意：本题相对原题稍作改动

示例：

输入： 1->2->3->4->5 和 k = 2
输出： 4
说明：

给定的 k 保证是有效的。
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
    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
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

        return l.val;
    }
}
