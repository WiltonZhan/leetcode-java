package com.WiltonZhan.leetcode.l201BitwiseAndOfNumbersRange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void rangeBitwiseAnd() {
        assertEquals(4, solution.rangeBitwiseAnd(5, 7));
        assertEquals(0, solution.rangeBitwiseAnd(0, 1));
    }
}