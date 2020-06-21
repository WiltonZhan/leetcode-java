package com.WiltonZhan.leetcode.l124BinaryTreeMaximumPathSum;

import org.junit.jupiter.api.Test;
import com.WiltonZhan.leetcode.l124BinaryTreeMaximumPathSum.Solution.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void maxPathSum() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        assertEquals(6, solution.maxPathSum(root1));

        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        assertEquals(42, solution.maxPathSum(root2));
    }
}