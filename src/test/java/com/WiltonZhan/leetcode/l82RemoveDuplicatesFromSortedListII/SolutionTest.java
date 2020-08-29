package com.WiltonZhan.leetcode.l82RemoveDuplicatesFromSortedListII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.WiltonZhan.leetcode.l82RemoveDuplicatesFromSortedListII.Solution.ListNode;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void deleteDuplicates() {
        ListNode head;
        head = initList(new int[]{1,2,2});
        assertArrayEquals(new Integer[]{1}, visit(solution.deleteDuplicates(head)));
        head = initList(new int[]{1,2,3,3,4,4,5});
        assertArrayEquals(new Integer[]{1,2,5}, visit(solution.deleteDuplicates(head)));
        head = initList(new int[]{1,1,1,2,3});
        assertArrayEquals(new Integer[]{2,3}, visit(solution.deleteDuplicates(head)));
        head = initList(new int[]{1,1,1,2,2,3,3,3,3});
        assertNull(solution.deleteDuplicates(head));
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