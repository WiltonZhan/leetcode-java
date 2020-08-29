package com.WiltonZhan.leetcode.l143ReorderList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.WiltonZhan.leetcode.l143ReorderList.Solution.ListNode;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void reorderList() {
        ListNode head = initList(new int[]{1,2,3,4});
        solution.reorderList(head);
        assertArrayEquals(new Integer[]{1,4,2,3}, visit(head));

        head = initList(new int[]{1,2,3,4,5});
        solution.reorderList(head);
        assertArrayEquals(new Integer[]{1,5,2,4,3}, visit(head));
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

    private Integer[] visit(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> vals = new ArrayList<>();
        while(head != null) {
            vals.add(head.val);
            head = head.next;
        }
        return vals.toArray(new Integer[]{});
    }
}