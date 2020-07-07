package com.WiltonZhan.leetcode.l112PathSum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
112. 路径总和
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    /**
     * 递归
     */
    public boolean hasPathSum_recurse(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 使用栈进行二叉树的深度优先遍历：
     *  1. 根节点入栈
     *  2. 从栈中弹出一个节点（遍历这个元素）并依次将其右孩子和左孩子入栈
     *  3. 重复这个过程直到栈为空
     *
     * 这里需要用到两个栈，一个栈存储节点，一个栈存储“路径和”。两个栈需要同步修改
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        nodeStack.push(root);
        valueStack.push(sum - root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int value = valueStack.pop();
            if (node.left == null && node.right == null && value == 0) {
                return true;
            } else {
                if (node.right != null) {
                    nodeStack.push(node.right);
                    valueStack.push(value - node.right.val);
                }
                if (node.left != null) {
                    nodeStack.push(node.left);
                    valueStack.push(value - node.left.val);
                }
            }
        }
        return false;
    }
}
