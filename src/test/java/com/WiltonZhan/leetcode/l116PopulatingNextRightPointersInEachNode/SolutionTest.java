package com.WiltonZhan.leetcode.l116PopulatingNextRightPointersInEachNode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void connect() {
        Solution.Node root = new Solution.Node(1);
        root.left = new Solution.Node(2);
        root.right = new Solution.Node(3);
        root.left.left = new Solution.Node(4);
        root.left.right = new Solution.Node(5);
        root.right.left = new Solution.Node(6);
        root.right.right = new Solution.Node(7);
        root = solution.connect(root);
        assertNull(root.next);
        assertEquals(3, root.left.next.val);
        assertNull(root.right.next);
        assertEquals(5, root.left.left.next.val);
        assertEquals(6, root.left.right.next.val);
        assertEquals(7, root.right.left.next.val);
        assertNull(root.right.right.next);
    }
}