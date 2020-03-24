package com.WiltonZhan.leetcode.l102BinaryTreeLevelOrderTraversal;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void levelOrder() {
        Solution.TreeNode root = new Solution.TreeNode(3);
        root.left = new Solution.TreeNode(9);
        root.right = new Solution.TreeNode(20);
        root.right.left = new Solution.TreeNode(15);
        root.right.right = new Solution.TreeNode(7);

        List<List<Integer>> levelOrder = solution.levelOrder(root);
        assertEquals(3, levelOrder.size());
        assertArrayEquals(new Integer[]{3}, levelOrder.get(0).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{9, 20}, levelOrder.get(1).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{15, 7}, levelOrder.get(2).toArray(new Integer[]{}));
    }
}