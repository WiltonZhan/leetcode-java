package com.WiltonZhan.leetcode.l66FractionToRecurringDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void fractionToDecimal() {
        assertEquals("0", solution.fractionToDecimal(0, 1));
        assertThrows(IllegalArgumentException.class, () -> solution.fractionToDecimal(1, 0));
        assertEquals("0.5", solution.fractionToDecimal(1, 2));
        assertEquals("2", solution.fractionToDecimal(2, 1));
        assertEquals("0.(6)", solution.fractionToDecimal(2, 3));
        assertEquals("0.1(6)", solution.fractionToDecimal(1, 6));
    }
}