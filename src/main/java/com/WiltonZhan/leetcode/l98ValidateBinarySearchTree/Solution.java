package com.WiltonZhan.leetcode.l98ValidateBinarySearchTree;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Util function
     * @param node  tree node
     * @param min   minimum value of node
     * @param max   maximum value of node
     * @return true if node is a valid binary search tree
     */
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) {
            return false;
        }

        return isValidBST(node.left, min, (long)node.val - 1) &&
                isValidBST(node.right, (long)node.val + 1, max);
    }
}
