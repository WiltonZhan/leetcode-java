package com.WiltonZhan.leetcode.l139WordBreak;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void wordBreak() {
        assertTrue(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
        assertTrue(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        assertFalse(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}