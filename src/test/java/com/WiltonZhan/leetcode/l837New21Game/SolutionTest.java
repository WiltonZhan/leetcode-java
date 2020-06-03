package com.WiltonZhan.leetcode.l837New21Game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void new21Game() {
        assertTrue(Math.abs(1.0 - solution.new21Game(10,1,10)) < 1e-5);
        assertTrue(Math.abs(0.6000 - solution.new21Game(6,1,10)) < 1e-5);
        assertTrue(Math.abs(0.73278 - solution.new21Game(21,17,10)) < 1e-5);
    }
}