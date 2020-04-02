package com.WiltonZhan.leetcode.l3LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 维护一个滑动窗口[l,r)。当下一个元素不在窗口中时，右边界加一；当下一个元素在窗口中时，左边界不断加一，直到窗口内没有重复元素
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int l = 0, r = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        while (l < s.length() && r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++)); // 移动右边界r
                result = Math.max(result, r - l);
            } else {
                set.remove(s.charAt(l++));  // 移动左边界l，并不断删除直至集合内没有重复元素
            }
        }

        return result;
    }
}
