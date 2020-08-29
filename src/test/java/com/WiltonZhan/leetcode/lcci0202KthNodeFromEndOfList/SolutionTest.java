package com.WiltonZhan.leetcode.lcci0202KthNodeFromEndOfList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.WiltonZhan.leetcode.lcci0202KthNodeFromEndOfList.Solution.ListNode;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void kthToLast() {
        int[] nums = new int[]{2, 3, 4, 5};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int num: nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }

        assertEquals(4, solution.kthToLast(head, 2));
        assertEquals(5, solution.kthToLast(head, 1));
        assertEquals(1, solution.kthToLast(head, 5));
    }
}