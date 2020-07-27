package com.WiltonZhan.leetcode.lcci0201RemoveDuplicateNode;

import org.junit.jupiter.api.Test;
import com.WiltonZhan.leetcode.lcci0201RemoveDuplicateNode.Solution.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    private ListNode buildList(int[] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int val: vals) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }

    private Integer[] visitList (ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        return vals.toArray(new Integer[]{});
    }

    @Test
    void removeDuplicateNodes() {
        assertArrayEquals(new Integer[]{1,2,3}, visitList(solution.removeDuplicateNodes(buildList(new int[]{1, 2, 3, 3, 2, 1}))));
        assertArrayEquals(new Integer[]{1,2}, visitList(solution.removeDuplicateNodes(buildList(new int[]{1,1,1,1,2}))));
    }
}