package com.WiltonZhan.leetcode.l100SameTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.WiltonZhan.leetcode.l100SameTree.Solution.TreeNode;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isSameTree() {
        TreeNode root1 = null, root2 = null;
        assertTrue(solution.isSameTree(root1, root2));
        root1 = new TreeNode(1);
        root2 = new TreeNode(1);
        assertTrue(solution.isSameTree(root1, root2));
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        assertTrue(solution.isSameTree(root1, root2));
        root1.left.left = new TreeNode(1);
        assertFalse(solution.isSameTree(root1, root2));
    }
}