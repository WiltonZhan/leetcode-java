package com.WiltonZhan.leetcode.l114FlattenBinaryTreeToLinkedList;

import java.util.ArrayList;
import java.util.List;

/*
114. 二叉树展开为链表
给定一个二叉树，原地将它展开为一个单链表。



例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 将二叉树展开为单链表之后，链表元素之间的先后顺序就是原二叉树的前序遍历顺序，所以我们开一先获得前序遍历序列，再展开
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> preorderList = new ArrayList<>();
        preorderTraversal(root, preorderList);
        int size = preorderList.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = preorderList.get(i - 1);
            TreeNode curr = preorderList.get(i);
            prev.left = null;
            prev.right = curr;
        }

    }

    private void preorderTraversal(TreeNode root, List<TreeNode> preorderList) {
        if (root != null) {
            preorderList.add(root);
            preorderTraversal(root.left, preorderList);
            preorderTraversal(root.right, preorderList);
        }
    }
}
