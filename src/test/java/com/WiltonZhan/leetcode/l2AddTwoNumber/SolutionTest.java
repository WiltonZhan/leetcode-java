package com.WiltonZhan.leetcode.l2AddTwoNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void addTwoNumbers() {
        Solution.ListNode l1 = new Solution.ListNode(2);
        l1.next = new Solution.ListNode(4);
        l1.next.next = new Solution.ListNode(3);
        Solution.ListNode l2 = new Solution.ListNode(5);
        l2.next = new Solution.ListNode(6);
        l2.next.next = new Solution.ListNode(4);
        Solution.ListNode sum1 = solution.addTwoNumbers(l1, l2);
        assertEquals(7, sum1.val);
        assertEquals(0, sum1.next.val);
        assertEquals(8, sum1.next.next.val);
    }
}