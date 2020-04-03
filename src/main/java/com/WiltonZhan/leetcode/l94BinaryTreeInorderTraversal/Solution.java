package com.WiltonZhan.leetcode.l94BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，返回它的中序遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inOrderTraversal(root, result);
        return result;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> inOrderList) {
        if (root.left != null) {
            inOrderTraversal(root.left, inOrderList);
        }
        inOrderList.add(root.val);
        if (root.right != null) {
            inOrderTraversal(root.right, inOrderList);
        }
    }
}
