package com.WiltonZhan.leetcode.l61RotateList;

import org.junit.jupiter.api.Test;
import com.WiltonZhan.leetcode.l61RotateList.Solution.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void rotateRight() {
        ListNode head1 = initList(new int[]{1,2,3,4,5});
        assertArrayEquals(new Integer[]{4,5,1,2,3}, visit(solution.rotateRight(head1, 2)));
        ListNode head2 = initList(new int[]{0,1,2});
        assertArrayEquals(new Integer[]{2,0,1}, visit(solution.rotateRight(head2, 4)));
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