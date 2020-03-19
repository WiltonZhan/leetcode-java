package com.WiltonZhan.leetcode.l38CountAndSay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void countAndSay() {
        assertEquals("1", solution.countAndSay(1));
        assertEquals("11", solution.countAndSay(2));
        assertEquals("1211", solution.countAndSay(4));
        assertEquals("13211311123113112211", solution.countAndSay(10));
    }
}