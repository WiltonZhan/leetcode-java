package com.WiltonZhan.leetcode.l1108DefangingAndIpAddress;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void defangIPaddr() {
        assertEquals("1[.]1[.]1[.]1", solution.defangIPaddr("1.1.1.1"));
        assertEquals("255[.]100[.]50[.]0", solution.defangIPaddr("255.100.50.0"));
    }
}