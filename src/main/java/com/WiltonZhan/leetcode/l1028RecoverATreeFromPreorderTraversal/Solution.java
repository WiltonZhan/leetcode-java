package com.WiltonZhan.leetcode.l1028RecoverATreeFromPreorderTraversal;

import java.util.Deque;
import java.util.LinkedList;

/*
1028. 从先序遍历还原二叉树
我们从二叉树的根节点 root 开始进行深度优先搜索。

在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。

如果节点只有一个子节点，那么保证该子节点为左子节点。

给出遍历输出 S，还原树并返回其根节点 root。



示例 1：



输入："1-2--3--4-5--6--7"
输出：[1,2,5,3,4,6,7]
示例 2：



输入："1-2--3---4-5--6---7"
输出：[1,2,5,3,null,6,null,4,null,7]
示例 3：



输入："1-401--349---90--88"
输出：[1,401,null,349,88,90]


提示：

原始树中的节点数介于 1 和 1000 之间。
每个节点的值介于 1 和 10 ^ 9 之间。
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    /**
     *  每次从字符串S中提取出一个节点的值和它的深度信息。然后考虑将当前节点放在何处，假设上一个节点为P，当前节点为C。那么只有两种情况：
     *      1. C是P的左子节点；
     *      2. C是根节点到P(不包括P)这一条路径上某一个节点的右子节点。
     *  我们可以记录下根节点到当前节点路径上的所有节点，以处理这两种情况。
     */
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        int idx = 0;
        while(idx < S.length()) {
            int level = 0;
            while (S.charAt(idx) == '-') {
                level++;
                idx++;
            }
            int value = 0;
            while(idx < S.length() && Character.isDigit(S.charAt(idx))) {
                value = value * 10 + (S.charAt(idx) - '0');
                idx++;
            }

            TreeNode cur = new TreeNode(value);
            if (level == stack.size()) {
                if (!stack.isEmpty()) {
                    stack.peek().left = cur;
                }
            } else {
                while (level != stack.size()) {
                    stack.pop();
                }
                stack.peek().right = cur;
            }
            stack.push(cur);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }
}
