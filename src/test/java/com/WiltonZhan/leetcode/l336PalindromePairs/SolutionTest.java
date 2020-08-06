package com.WiltonZhan.leetcode.l336PalindromePairs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void palindromePairs() {
        List<List<Integer>> pairs;
        pairs = solution.palindromePairs(new String[]{"a", ""});
        assertEquals(2, pairs.size());
        pairs = solution.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
        assertEquals(4, pairs.size());
        pairs = solution.palindromePairs(new String[]{"bat","tab","cat"});
        assertEquals(2, pairs.size());
    }
}