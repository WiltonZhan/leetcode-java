package com.WiltonZhan.leetcode.l19RemoveNthNodeFromEndOfList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void removeNthFromEnd() {
        Solution.ListNode head = new Solution.ListNode(1);
        Solution.ListNode tempNode = head;
        for (int i = 2; i <= 5; i++) {
            tempNode.next = new Solution.ListNode(i);
            tempNode = tempNode.next;
        }
        head = solution.removeNthFromEnd(head, 2);
        assertEquals(head.next.next.next.val, 5);
        head.next = null;
        head = solution.removeNthFromEnd(head, 1);
        assertNull(head);
    }

    @Test
    void removeNthFromEnd2() {
        Solution.ListNode head = new Solution.ListNode(1);
        Solution.ListNode tempNode = head;
        for (int i = 2; i <= 5; i++) {
            tempNode.next = new Solution.ListNode(i);
            tempNode = tempNode.next;
        }
        head = solution.removeNthFromEnd2(head, 2);
        assertEquals(head.next.next.next.val, 5);
        head.next = null;
        head = solution.removeNthFromEnd2(head, 1);
        assertNull(head);
    }
}