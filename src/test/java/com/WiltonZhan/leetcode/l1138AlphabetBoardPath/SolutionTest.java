package com.WiltonZhan.leetcode.l1138AlphabetBoardPath;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void alphabetBoardPath() {
        assertEquals("DDDDD!UUUUUR!", solution.alphabetBoardPath("zb"));
        assertEquals("DDDDD!", solution.alphabetBoardPath("z"));
        assertEquals("DDR!UURRR!!DDD!", solution.alphabetBoardPath("leet"));
        assertEquals("RR!DDRR!UUL!R!", solution.alphabetBoardPath("code"));
    }
}