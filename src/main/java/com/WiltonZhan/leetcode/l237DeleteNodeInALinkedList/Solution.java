package com.WiltonZhan.leetcode.l237DeleteNodeInALinkedList;

public class Solution {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     *  由于无法访问前一个结点，所以只需要用下一个节点代替当前节点即可
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
