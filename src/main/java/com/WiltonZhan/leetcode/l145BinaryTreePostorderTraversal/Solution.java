package com.WiltonZhan.leetcode.l145BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode (int val) {this.val = val;}
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> postOrder = new ArrayList<>();
//        postorderTraversal_recurse(root, postOrder);
//        return postOrder;
        return postorderTraversal_iterate(root);
    }

    /**
     * 递归
     */
    private void postorderTraversal_recurse(TreeNode root, List<Integer> postorder) {
        if (root == null) {
            return;
        }
        postorderTraversal_recurse(root.left, postorder);
        postorderTraversal_recurse(root.right, postorder);
        postorder.add(root.val);
    }

    /**
     * 迭代（使用栈）：
     * 入栈顺序为：root -> right -> left。
     * 对于每一个节点：当其左右子节点入栈后，将该节点的左右子节点设置为null。然后将栈顶元素的右左节点依次入栈，并将栈顶元素的左右子节点设置为null。
     * 当栈顶元素不存在子节点时，弹出并追加值到后序遍历序列。
     * 重复操作直到栈为空。
     */
    private List<Integer> postorderTraversal_iterate(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left == null && top.right == null) {
                postorder.add(top.val);
                stack.pop();
                continue;
            }
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
            top.left = null;
            top.right = null;

        }

        return postorder;
    }
}
