package com.WiltonZhan.leetcode.l145BinaryTreePostorderTraversal;

import org.junit.jupiter.api.Test;
import com.WiltonZhan.leetcode.l145BinaryTreePostorderTraversal.Solution.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void postorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        assertArrayEquals(new Integer[]{3,2,1}, solution.postorderTraversal(root).toArray());
    }
}