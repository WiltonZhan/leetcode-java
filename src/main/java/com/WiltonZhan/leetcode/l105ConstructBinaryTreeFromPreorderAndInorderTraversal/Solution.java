package com.WiltonZhan.leetcode.l105ConstructBinaryTreeFromPreorderAndInorderTraversal;

/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    /**
     * 找出左右子树的前序和中序遍历序列，递归构造
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || (preorder.length == 0 && inorder.length == 0) || preorder.length != inorder.length) {
            return null;
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int ls, int le, int[] inorder, int rs, int re) {
        if (ls > le || rs > re) {
            return null;
        }
        int rootVal = preorder[ls];
        int rootIdxOfInorder = rs;
        while(inorder[rootIdxOfInorder] != rootVal && rootIdxOfInorder < re) {
            rootIdxOfInorder++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, ls + 1, ls + rootIdxOfInorder - rs, inorder, rs, rootIdxOfInorder - 1);
        root.right = buildTree(preorder, ls + rootIdxOfInorder - rs + 1, le, inorder, rootIdxOfInorder + 1, re);

        return root;
    }
}
