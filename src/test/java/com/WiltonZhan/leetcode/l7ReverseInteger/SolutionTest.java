package com.WiltonZhan.leetcode.l7ReverseInteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void reverse() {
        assertEquals(solution.reverse(123), 321);
        assertEquals(solution.reverse(-123), -321);
        assertEquals(solution.reverse(120), 21);
        assertEquals(solution.reverse(1534236469), 0);
        assertEquals(solution.reverse(-2147483648), 0);
    }
}