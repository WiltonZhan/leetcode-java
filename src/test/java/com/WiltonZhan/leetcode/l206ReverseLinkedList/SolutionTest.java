package com.WiltonZhan.leetcode.l206ReverseLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void reverseList() {
        Solution.ListNode head = new Solution.ListNode(1);
        Solution.ListNode tempNode = head;
        for (int i = 2; i <= 5; i++) {
            tempNode.next = new Solution.ListNode(i);
            tempNode = tempNode.next;
        }

        head = solution.reverseList(head);
        assertEquals(5, head.val);
        assertEquals(4, head.next.val);
        assertEquals(3, head.next.next.val);
        assertEquals(2, head.next.next.next.val);
        assertEquals(1, head.next.next.next.next.val);
        assertNull(head.next.next.next.next.next);
    }
}