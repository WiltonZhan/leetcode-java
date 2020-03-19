package com.WiltonZhan.leetcode.l8StringToIntegerAtoi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void myAtoi() {
        assertEquals(0, solution.myAtoi("0-1"));
        assertEquals(-1, solution.myAtoi("-000000000000001"));
        assertEquals(12345678, solution.myAtoi("  0000000000012345678"));
        assertEquals(Integer.MAX_VALUE, solution.myAtoi("9223372036854775809"));
        assertEquals(Integer.MAX_VALUE, solution.myAtoi("2147483648"));
        assertEquals(1, solution.myAtoi("1"));
        assertEquals(42, solution.myAtoi("42"));
        assertEquals(-42, solution.myAtoi("-42"));
        assertEquals(42, solution.myAtoi("+42"));
        assertEquals(4193, solution.myAtoi("4193 with words"));
        assertEquals(0, solution.myAtoi("words and 987"));
        assertEquals(Integer.MIN_VALUE, solution.myAtoi("-91283472332"));
    }
}