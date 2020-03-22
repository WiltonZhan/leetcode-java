package com.WiltonZhan.leetcode.l141LinkedListCycle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();
    private Solution.ListNode list1, list2, list3;

    void initLists() {
        Solution.ListNode tempNode;
        list1 = new Solution.ListNode(3);
        tempNode = list1;
        for(int i: new int[]{2, 0, -4}) {
            tempNode.next = new Solution.ListNode(i);
            tempNode = tempNode.next;
        }
        tempNode.next = list1.next;

        list2 = new Solution.ListNode(1);
        tempNode = list2;
        tempNode.next = new Solution.ListNode(2);
        tempNode = tempNode.next;
        tempNode.next = list2;

        list3 = new Solution.ListNode(1);
    }

    @Test
    void hasCycle() {
        initLists();
        assertTrue(solution.hasCycle(list1));
        assertTrue(solution.hasCycle(list2));
        assertFalse(solution.hasCycle(list3));
    }

    @Test
    void hasCycle2() {
        initLists();
        assertTrue(solution.hasCycle2(list1));
        assertTrue(solution.hasCycle2(list2));
        assertFalse(solution.hasCycle2(list3));
    }
}