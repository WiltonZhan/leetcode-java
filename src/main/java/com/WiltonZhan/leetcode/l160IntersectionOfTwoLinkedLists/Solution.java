package com.WiltonZhan.leetcode.l160IntersectionOfTwoLinkedLists;

import java.util.HashSet;
import java.util.Set;

/*
编写一个程序，找到两个单链表相交的起始节点。

注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }


    /**
     *  时间复杂度：O(m+n)
     *  空间复杂度：O(m)或O(n)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> aNodes = new HashSet<>();
        while (headA != null) {
            aNodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (aNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
