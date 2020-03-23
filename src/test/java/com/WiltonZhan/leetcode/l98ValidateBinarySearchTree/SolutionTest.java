package com.WiltonZhan.leetcode.l98ValidateBinarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void isValidBST() {
        Solution.TreeNode root1 = new Solution.TreeNode(2);
        root1.left = new Solution.TreeNode(1);
        root1.right = new Solution.TreeNode(3);

        Solution.TreeNode root2 = new Solution.TreeNode(5);
        root2.left = new Solution.TreeNode(1);
        root2.right = new Solution.TreeNode(4);
        root2.right.left = new Solution.TreeNode(3);
        root2.right.right = new Solution.TreeNode(6);

        Solution.TreeNode root3 = new Solution.TreeNode(10);
        root3.left = new Solution.TreeNode(5);
        root3.right = new Solution.TreeNode(15);
        root3.right.left = new Solution.TreeNode(6);
        root3.right.right = new Solution.TreeNode(20);

        Solution.TreeNode root4 = new Solution.TreeNode(1);
        root4.left = new Solution.TreeNode(1);

        Solution.TreeNode root5 = new Solution.TreeNode(2147483647);

        Solution.TreeNode root6 = new Solution.TreeNode(-2147483648);
        root6.left = new Solution.TreeNode(-2147483648);

        assertFalse(solution.isValidBST(root6));
        assertTrue(solution.isValidBST(root5));
        assertFalse(solution.isValidBST(root4));
        assertFalse(solution.isValidBST(root3));
        assertTrue(solution.isValidBST(root1));
        assertFalse(solution.isValidBST(root2));
    }
}