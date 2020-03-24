package com.WiltonZhan.leetcode.l108ConvertSortedArrayToBinarySearchTree;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode parent = new TreeNode(nums[mid]);
        parent.left = buildBST(nums, left, mid - 1);
        parent.right = buildBST(nums, mid + 1, right);
        return parent;
    }
}
