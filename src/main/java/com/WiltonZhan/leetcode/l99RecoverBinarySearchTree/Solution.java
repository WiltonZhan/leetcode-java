package com.WiltonZhan.leetcode.l99RecoverBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/*
二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。

示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2
示例 2:

输入: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

输出: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
进阶:

使用 O(n) 空间复杂度的解法很容易实现。
你能想出一个只使用常数空间的解决方案吗？
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    /**
     *  BST的中序遍历序列为一个递增序列，我们可以根据这一点找出有问题的那两个节点a和b，然后交换它们。
     *  假设我们有一个递增序列[1,2,3,4,5]，对于数字2，它可能和3交换，也可能和4交换……，得到的结果分别为[1,3,2,4,5]和[1,4,3,2,5]。
     *  显然序列中不满足nums[i] < nums[i+1]的值就是有问题的位置。不满足这个条件的位置可能有两个（不相邻）或一个（相邻）。
     *  所以可以先对有问题的BST进行中序遍历，然后找到有问题的两个位置，最后修复二叉树
    */
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorderTraverse(root, nums);
        int[] swapped = findSwappedTwoNums(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    private void inorderTraverse(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left, nums);
        nums.add(root.val);
        inorderTraverse(root.right, nums);
    }

    private int[] findSwappedTwoNums(List<Integer> nums) {
        int x = -1, y = -1;
        int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }

        return new int[]{x, y};
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = (root.val == x ? y : x);
                count--;
                if (count == 0) {
                    return;
                }
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
    }
}
