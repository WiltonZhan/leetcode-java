package com.WiltonZhan.leetcode.lcof18ShanChuDianBiaoDeJieDian;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.WiltonZhan.leetcode.lcof18ShanChuDianBiaoDeJieDian.Solution.ListNode;

import java.util.ArrayList;
import java.util.List;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void deleteNode() {
        ListNode head;
        head = initList(new int[]{4,5,1,9});
        assertArrayEquals(new Integer[]{4,1,9}, visit(solution.deleteNode(head, 5)));
        head = initList(new int[]{4,5,1,9});
        assertArrayEquals(new Integer[]{4,5,9}, visit(solution.deleteNode(head, 1)));
        head = initList(new int[]{4,5,1,9});
        assertArrayEquals(new Integer[]{4,5,1,9}, visit(solution.deleteNode(head, 10)));
        head = initList(new int[]{4,5,1,9});
        assertArrayEquals(new Integer[]{5,1,9}, visit(solution.deleteNode(head, 4)));
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