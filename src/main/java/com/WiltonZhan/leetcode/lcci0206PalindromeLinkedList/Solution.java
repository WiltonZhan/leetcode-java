package com.WiltonZhan.leetcode.lcci0206PalindromeLinkedList;

/*
面试题 02.06. 回文链表
编写一个函数，检查输入的链表是否是回文的。



示例 1：

输入： 1->2
输出： false
示例 2：

输入： 1->2->2->1
输出： true


进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {this.val = val;}
    }

    /**
     * 找到链表中点，将链表拆分为两个链表，然后反转第二个，最后对比。
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = middleNode(head);
        ListNode secondHead = reverseList(mid.next);
        // 前半部分可能多一个节点
        while (secondHead != null) {
            if (head.val != secondHead.val) {
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        return true;
    }

    private ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
