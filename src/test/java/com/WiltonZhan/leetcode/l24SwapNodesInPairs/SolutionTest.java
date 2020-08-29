package com.WiltonZhan.leetcode.l24SwapNodesInPairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.WiltonZhan.leetcode.l24SwapNodesInPairs.Solution.ListNode;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void swapPairs() {
        ListNode head = initList(new int[]{1,2,3,4});
        assertArrayEquals(new Integer[]{2,1,4,3}, visit(solution.swapPairs(head)));
        head = initList(new int[]{1,2,3,4,5});
        assertArrayEquals(new Integer[]{2,1,4,3,5}, visit(solution.swapPairs(head)));
        
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