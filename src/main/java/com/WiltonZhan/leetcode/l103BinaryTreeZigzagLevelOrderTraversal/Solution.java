package com.WiltonZhan.leetcode.l103BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

/*
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.offer(root);
        boolean l2r = true; // 入栈顺序
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int count = queue.size(); count > 0; count--) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (l2r) {
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
            }
            while (!stack.isEmpty()) {
                queue.offer(stack.pop());
            }
            levelOrder.add(list);
            l2r = !l2r;
        }

        return levelOrder;
    }
}
