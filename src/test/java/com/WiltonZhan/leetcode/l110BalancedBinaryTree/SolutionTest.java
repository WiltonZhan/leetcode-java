package com.WiltonZhan.leetcode.l110BalancedBinaryTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.WiltonZhan.leetcode.l110BalancedBinaryTree.Solution.TreeNode;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isBalanced() {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        assertTrue(solution.isBalanced(root1));
    }
}