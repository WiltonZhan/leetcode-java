package com.WiltonZhan.leetcode.l337HouseRobberIII;

import java.util.HashMap;
import java.util.Map;

/*
337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *  原问题可以转化为：在不同时选中具有父子关系的节点的前提下，所能获取的最大收益为多少。
     *  考虑每一个节点node，它有两种状态：选中和不选中。
     *  分别用choose(node)和drop(node)表示选择节点node和不选择节点node所能获得的最大收益，则：
     *      选择node的最大收益为：node.val + drop(node.left) + drop(node.right);
     *      不选择node的最大收益为：max{choose(node.left), drop(node.left)} + max{choose(node.right), drop(node.right}
     */
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> choose = new HashMap<>(), drop = new HashMap<>();
        dfs(root, choose, drop);
        return Math.max(choose.getOrDefault(root, 0), drop.getOrDefault(root, 0));
    }

    private void dfs(TreeNode root, Map<TreeNode, Integer> choose, Map<TreeNode, Integer> drop) {
        if (root == null) {
            return;
        }
        dfs(root.left, choose, drop);
        dfs(root.right, choose, drop);
        choose.put(root, root.val + drop.getOrDefault(root.left, 0) + drop.getOrDefault(root.right, 0));
        drop.put(root, Math.max(choose.getOrDefault(root.left, 0), drop.getOrDefault(root.left, 0)) +
                Math.max(choose.getOrDefault(root.right, 0), drop.getOrDefault(root.right, 0))
        );
    }
}
