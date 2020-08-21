package com.WiltonZhan.leetcode.l111MinimumDepthOfBinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.WiltonZhan.leetcode.l111MinimumDepthOfBinaryTree.Solution.TreeNode;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void minDepth() {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        assertEquals(2, solution.minDepth(root1));
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        assertEquals(2, solution.minDepth(root1));
    }
}