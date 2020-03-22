package com.WiltonZhan.leetcode.l141LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    /**
     * 采用哈希表
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while(head != null) {
            if (nodes.contains(head)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 采用快慢指针
     */
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while(slow != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
