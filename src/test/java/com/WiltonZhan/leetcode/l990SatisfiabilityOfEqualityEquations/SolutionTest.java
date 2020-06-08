package com.WiltonZhan.leetcode.l990SatisfiabilityOfEqualityEquations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void equationsPossible() {
        assertFalse(solution.equationsPossible(new String[]{"a==b","b!=a"}));
        assertTrue(solution.equationsPossible(new String[]{"b==a","a==b"}));
        assertTrue(solution.equationsPossible(new String[]{"a==b","b==c","a==c"}));
        assertFalse(solution.equationsPossible(new String[]{"a==b","b!=c","c==a"}));
        assertTrue(solution.equationsPossible(new String[]{"c==c","b==d","x!=z"}));
    }
}