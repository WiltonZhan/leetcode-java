package com.WiltonZhan.leetcode.l49GroupAnagrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void groupAnagrams() {
        assertEquals(3, solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).size());
    }
}