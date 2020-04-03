package com.WiltonZhan.leetcode.l94BinaryTreeInorderTraversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void inorderTraversal() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.right = new Solution.TreeNode(2);
        root.right.left = new Solution.TreeNode(3);

        assertArrayEquals(new Integer[]{1,3,2}, solution.inorderTraversal(root).toArray(new Integer[]{}));
    }
}