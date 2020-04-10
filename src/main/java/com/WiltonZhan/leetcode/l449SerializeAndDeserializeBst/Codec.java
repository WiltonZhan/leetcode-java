package com.WiltonZhan.leetcode.l449SerializeAndDeserializeBst;

import java.util.LinkedList;
import java.util.Queue;

/*
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

示例:

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class Codec {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return sb.toString();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val).append(",");
        while(!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if(curNode.left != null) {
                sb.append(curNode.left.val).append(",");
                queue.add(curNode.left);
            }else {
                sb.append("N,");
            }
            if(curNode.right != null) {
                sb.append(curNode.right.val).append(",");
                queue.add(curNode.right);
            }else {
                sb.append("N,");
            }
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] nodeVals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodeVals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < nodeVals.length && !nodeVals[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(nodeVals[i++]));
                queue.offer(node.left);
            } else {
                i++;
            }
            if (i < nodeVals.length && !nodeVals[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(nodeVals[i++]));
                queue.offer(node.right);
            } else {
                i++;
            }
        }

        return root;
    }
}
