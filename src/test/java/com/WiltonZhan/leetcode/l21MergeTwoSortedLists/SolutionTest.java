package com.WiltonZhan.leetcode.l21MergeTwoSortedLists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void mergeTwoLists() {
        Solution.ListNode l1 = new Solution.ListNode(1);
        Solution.ListNode temNode = l1;
        for (int i : new int[]{2, 4}) {
            temNode.next = new Solution.ListNode(i);
            temNode = temNode.next;
        }
        Solution.ListNode l2 = new Solution.ListNode(1);
        temNode = l2;
        for (int i: new int[]{3, 4}) {
            temNode.next = new Solution.ListNode(i);
            temNode = temNode.next;
        }

        temNode = solution.mergeTwoLists(l1, l2);
        assertEquals(1, temNode.val);
        assertEquals(1, temNode.next.val);
        assertEquals(2, temNode.next.next.val);
        assertEquals(3, temNode.next.next.next.val);
        assertEquals(4, temNode.next.next.next.next.val);
        assertEquals(4, temNode.next.next.next.next.next.val);
        assertNull(temNode.next.next.next.next.next.next);
    }
}