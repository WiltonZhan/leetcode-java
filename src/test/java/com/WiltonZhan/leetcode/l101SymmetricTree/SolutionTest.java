package com.WiltonZhan.leetcode.l101SymmetricTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isSymmetric() {
        Solution.TreeNode root1 = new Solution.TreeNode(1);
        root1.left = new Solution.TreeNode(2);
        root1.right = new Solution.TreeNode(2);
        root1.left.left = new Solution.TreeNode(3);
        root1.left.right = new Solution.TreeNode(4);
        root1.right.left = new Solution.TreeNode(4);
        root1.right.right = new Solution.TreeNode(3);

        Solution.TreeNode root2 = new Solution.TreeNode(1);
        root2.left = new Solution.TreeNode(2);
        root2.right = new Solution.TreeNode(2);
        root2.left.right = new Solution.TreeNode(3);
        root2.right.right = new Solution.TreeNode(3);

        assertTrue(solution.isSymmetric(root1));
        assertFalse(solution.isSymmetric(root2));
    }
}