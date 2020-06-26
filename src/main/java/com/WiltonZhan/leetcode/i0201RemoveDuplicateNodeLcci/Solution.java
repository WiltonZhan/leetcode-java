package com.WiltonZhan.leetcode.i0201RemoveDuplicateNodeLcci;

import java.util.HashSet;
import java.util.Set;

/*
面试题 02.01. 移除重复节点
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
提示：

链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。
进阶：

如果不得使用临时缓冲区，该怎么解决？
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     *  保存已出现的节点，然后遍历每个节点。若节点的值已存在，则删除该节点，否则将节点的值加入已出现的节点中
     */
    public ListNode removeDuplicateNodes_save_vals(ListNode head) {
        if (head == null) {
            return null;
        }

        Set<Integer> visitedVals = new HashSet<>();
        visitedVals.add(head.val);
        ListNode node = head;
        while (node.next != null) {
            if (visitedVals.contains(node.next.val)) {
                node.next = node.next.next;
                continue;
            }
            visitedVals.add(node.next.val);
            node = node.next;
        }
        return head;
    }

    /**
     *  不使用临时缓冲区，为了确定当前遍历的值是否存在，我们需要再次遍历当前节点前面的所有节点
     */
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            ListNode cur = head;
            boolean exist = false;
            while (cur != node.next) {
                if (cur.val == node.next.val) {
                    node.next = node.next.next;
                    exist = true;
                    break;
                }
                cur = cur.next;
            }
            if (!exist) {
                node = node.next;
            }
        }
        return head;
    }
}
