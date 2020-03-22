package com.WiltonZhan.leetcode.l234PalindromeLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isPalindrome() {
        Solution.ListNode head1 = new Solution.ListNode(1);
        head1.next = new Solution.ListNode(2);
        Solution.ListNode  head2 = new Solution.ListNode(1);
        Solution.ListNode tempNode = head2;
        for(int i: new int[]{2, 2, 1}) {
            tempNode.next = new Solution.ListNode(i);
            tempNode = tempNode.next;
        }

        assertFalse(solution.isPalindrome(head1));
        assertTrue(solution.isPalindrome(head2));
    }
}