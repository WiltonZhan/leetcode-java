package com.WiltonZhan.leetcode.l725SplitLinkedListInParts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.WiltonZhan.leetcode.l725SplitLinkedListInParts.Solution.ListNode;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void splitListToParts() {
        ListNode root = initList(new int[]{1,2,3,4});
        assertEquals(5, solution.splitListToParts(root, 5).length);
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