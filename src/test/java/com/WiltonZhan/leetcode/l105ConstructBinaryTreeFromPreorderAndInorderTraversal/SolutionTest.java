package com.WiltonZhan.leetcode.l105ConstructBinaryTreeFromPreorderAndInorderTraversal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void buildTree() {
        Solution.TreeNode root = solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        assertEquals(3, root.val);
        assertEquals(9, root.left.val);
        assertEquals(20, root.right.val);
        assertEquals(15, root.right.left.val);
        assertEquals(7, root.right.right.val);
    }
}