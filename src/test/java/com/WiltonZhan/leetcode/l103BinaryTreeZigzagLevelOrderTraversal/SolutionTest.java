package com.WiltonZhan.leetcode.l103BinaryTreeZigzagLevelOrderTraversal;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void zigzagLevelorder() {
        Solution.TreeNode root1 = new Solution.TreeNode(3);
        root1.left = new Solution.TreeNode(9);
        root1.right = new Solution.TreeNode(20);
        root1.right.left = new Solution.TreeNode(15);
        root1.right.right = new Solution.TreeNode(7);
        List<List<Integer>> lo1 = solution.zigzagLevelOrder(root1);
        assertEquals(3, lo1.size());
        assertArrayEquals(new Integer[]{3}, lo1.get(0).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{20,9}, lo1.get(1).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{15,7}, lo1.get(2).toArray(new Integer[]{}));

        Solution.TreeNode root2 = new Solution.TreeNode(1);
        root2.left = new Solution.TreeNode(2);
        root2.right = new Solution.TreeNode(3);
        root2.left.left = new Solution.TreeNode(4);
        root2.right.right = new Solution.TreeNode(5);
        List<List<Integer>> lo2 = solution.zigzagLevelOrder(root2);
        assertEquals(3, lo2.size());
        assertArrayEquals(new Integer[]{1}, lo2.get(0).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{3,2}, lo2.get(1).toArray(new Integer[]{}));
        assertArrayEquals(new Integer[]{4,5}, lo2.get(2).toArray(new Integer[]{}));
    }
}