package com.WiltonZhan.leetcode.l112PathSum;

import org.junit.jupiter.api.Test;
import com.WiltonZhan.leetcode.l112PathSum.Solution.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void hasPathSum() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        assertTrue(solution.hasPathSum(root, 22));
        assertTrue(solution.hasPathSum(root, 26));
    }
}