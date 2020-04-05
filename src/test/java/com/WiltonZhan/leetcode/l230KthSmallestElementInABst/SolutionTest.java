package com.WiltonZhan.leetcode.l230KthSmallestElementInABst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void kthSmallest() {
        Solution.TreeNode root1 = new Solution.TreeNode(3);
        root1.left = new Solution.TreeNode(1);
        root1.left.right = new Solution.TreeNode(2);
        root1.right = new Solution.TreeNode(4);
        assertEquals(1, solution.kthSmallest(root1, 1));

        Solution.TreeNode root2 = new Solution.TreeNode(5);
        root2.left = new Solution.TreeNode(3);
        root2.left.left = new Solution.TreeNode(2);
        root2.left.right = new Solution.TreeNode(4);
        root2.left.left.left = new Solution.TreeNode(1);
        root2.right = new Solution.TreeNode(6);
        assertEquals(3, solution.kthSmallest(root2, 3));
    }
}