package com.WiltonZhan.leetcode.l682BaseballGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void calPoints() {
        assertEquals(30, solution.calPoints(new String[]{"5","2","C","D","+"}));
        assertEquals(27, solution.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}