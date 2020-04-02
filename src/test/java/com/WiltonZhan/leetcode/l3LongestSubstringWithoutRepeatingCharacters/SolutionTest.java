package com.WiltonZhan.leetcode.l3LongestSubstringWithoutRepeatingCharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3, solution.lengthOfLongestSubstring("dvdf"));
        assertEquals(2, solution.lengthOfLongestSubstring("aab"));
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, solution.lengthOfLongestSubstring("bbb"));
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"));
    }
}