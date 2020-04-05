package com.WiltonZhan.leetcode.l116PopulatingNextRightPointersInEachNode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Solution {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     *  使用层序遍历的思想，空间复杂度为O(N)
     */
    public Node connect(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            int count = queue.size();
            assert (count % 2 == 0);

            Node node1 = queue.poll();
            if (node1.left != null && node1.right != null) {
                queue.offer(node1.left);
                queue.offer(node1.right);
            }
            count --;
            Node node2;
            while (count > 0) {
                node2 = queue.poll();
                if (node2.left != null && node2.right != null) {
                    queue.offer(node2.left);
                    queue.offer(node2.right);
                }
                count--;

                node1.next = node2;
                node1 = node2;
            }
        }
        return root;
    }
}
