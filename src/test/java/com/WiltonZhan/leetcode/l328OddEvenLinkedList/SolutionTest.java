package com.WiltonZhan.leetcode.l328OddEvenLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void oddEvenList() {
        Solution.ListNode tempNode;
        Solution.ListNode head1 = new Solution.ListNode(1);
        tempNode = head1;
        for (int i: new int[]{2,3,4,5,6,7,8}) {
            tempNode.next = new Solution.ListNode(i);
            tempNode = tempNode.next;
        }
        Solution.ListNode oel1 = solution.oddEvenList(head1);
        int[] vals1 = new int[8];
        int idx = 0;
        while (oel1 != null) {
            vals1[idx++] = oel1.val;
            oel1 = oel1.next;
        }
        assertArrayEquals(new int[]{1,3,5,7,2,4,6,8}, vals1);


        Solution.ListNode head2 = new Solution.ListNode(1);
        tempNode = head2;
        for (int i: new int[]{2,3,4,5,6,7}) {
            tempNode.next = new Solution.ListNode(i);
            tempNode = tempNode.next;
        }
        Solution.ListNode oel2 = solution.oddEvenList(head2);
        int[] vals2 = new int[7];
        int i = 0;
        while (oel2 != null) {
            vals2[i++] = oel2.val;
            oel2 = oel2.next;
        }
        assertArrayEquals(new int[]{1,3,5,7,2,4,6}, vals2);

        Solution.ListNode head3 = new Solution.ListNode(1);
        Solution.ListNode ole3 = solution.oddEvenList(head3);
        assertNotNull(ole3);
        assertEquals(1, ole3.val);
        assertNull(ole3.next);

        Solution.ListNode head4 = new Solution.ListNode(1);
        head4.next = new Solution.ListNode(2);
        Solution.ListNode ole4 = solution.oddEvenList(head4);
        assertEquals(1, ole4.val);
        assertEquals(2, ole4.next.val);
        assertNull(ole4.next.next);
    }
}