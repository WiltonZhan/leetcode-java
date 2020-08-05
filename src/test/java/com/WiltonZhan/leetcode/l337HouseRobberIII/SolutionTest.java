package com.WiltonZhan.leetcode.l337HouseRobberIII;

import org.junit.jupiter.api.Test;
import com.WiltonZhan.leetcode.l337HouseRobberIII.Solution.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void rob() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        assertEquals(7, solution.rob(root));

        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        assertEquals(9, solution.rob(root));
    }
}