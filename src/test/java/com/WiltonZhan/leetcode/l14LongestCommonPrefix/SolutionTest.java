package com.WiltonZhan.leetcode.l14LongestCommonPrefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void longestCommonPrefix() {
        assertEquals("c", solution.longestCommonPrefix(new String[]{"c", "c"}));
        assertEquals("fl", solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        assertEquals("", solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}