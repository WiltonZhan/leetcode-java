package com.WiltonZhan.leetcode.lcci0206PalindromeLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.WiltonZhan.leetcode.lcci0206PalindromeLinkedList.Solution.ListNode;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isPalindrome() {
        ListNode head;
        head = initList(new int[]{1,2});
        assertFalse(solution.isPalindrome(head));
        head = initList(new int[]{1,2,1});
        assertTrue(solution.isPalindrome(head));
        head = initList(new int[]{1,1});
        assertTrue(solution.isPalindrome(head));
    }

    private ListNode initList(int[] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        ListNode head = new ListNode(vals[0]);
        ListNode temp = head;
        for (int i = 1; i < vals.length; i++) {
            temp.next = new ListNode(vals[i]);
            temp = temp.next;
        }
        return head;
    }
}