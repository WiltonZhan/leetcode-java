package com.WiltonZhan.leetcode.l234PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        while(head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int left = 0, right = vals.size() - 1;
        while(left <= right) {
            if (!vals.get(left++).equals(vals.get(right--))) {
                return false;
            }
        }
        return true;
    }
}
