package com.WiltonZhan.leetcode.l160IntersectionOfTwoLinkedLists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void getIntersectionNode() {
        Solution.ListNode intersection1 = new Solution.ListNode(8);
        intersection1.next = new Solution.ListNode(4);
        intersection1.next.next = new Solution.ListNode(5);
        Solution.ListNode la1 = new Solution.ListNode(4);
        la1.next = new Solution.ListNode(1);
        la1.next.next = intersection1;
        Solution.ListNode lb1 = new Solution.ListNode(5);
        lb1.next = new Solution.ListNode(0);
        lb1.next.next = new Solution.ListNode(1);
        lb1.next.next.next = intersection1;
        assertEquals(intersection1, solution.getIntersectionNode(la1, lb1));
    }
}