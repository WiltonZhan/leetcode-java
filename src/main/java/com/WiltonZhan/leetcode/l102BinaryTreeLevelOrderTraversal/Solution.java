package com.WiltonZhan.leetcode.l102BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> currentLevelNodes = new LinkedList<>();
        currentLevelNodes.add(root);
        while(!currentLevelNodes.isEmpty()) {
            int count = currentLevelNodes.size();
            List<Integer> list1 = new ArrayList<>(count);
            while(count > 0) {
                TreeNode node = currentLevelNodes.poll();
                assert node != null;
                list1.add(node.val);
                if (node.left != null) {
                    currentLevelNodes.add(node.left);
                }
                if (node.right != null) {
                    currentLevelNodes.add(node.right);
                }
                count--;
            }
            result.add(list1);
        }
        return result;
    }
}
