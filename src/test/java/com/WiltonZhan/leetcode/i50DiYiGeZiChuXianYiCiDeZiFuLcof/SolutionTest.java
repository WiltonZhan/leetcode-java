package com.WiltonZhan.leetcode.i50DiYiGeZiChuXianYiCiDeZiFuLcof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void firstUniqChar() {
        assertEquals('b', solution.firstUniqChar("abaccdeff"));
    }
}