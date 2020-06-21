package com.WiltonZhan.leetcode.l124BinaryTreeMaximumPathSum;

/*
124. 二叉树中的最大路径和
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {val = x;}
    }

    private int maxSum = Integer.MIN_VALUE; // 全局最大和

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxSum;
    }

    /**
     * 计算node节点对全局最大和的贡献值
     */
    private int maxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 只有当子节点的贡献值大于0时，才选取该子节点
        int leftMaxSum = Math.max(maxSum(node.left), 0);
        int rightMaxSum = Math.max(maxSum(node.right), 0);

        // 更新全局最大和，节点得最大路径和为该节点的值加上左右子节点的值
        maxSum = Math.max(node.val + leftMaxSum + rightMaxSum, maxSum);

        // 返回该节点的贡献值，贡献值会被父节点使用，因此只能选择该节点的一个子节点
        return node.val + Math.max(leftMaxSum, rightMaxSum);
    }
}
