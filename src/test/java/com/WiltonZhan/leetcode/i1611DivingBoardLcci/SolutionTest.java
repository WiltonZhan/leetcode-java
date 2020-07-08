package com.WiltonZhan.leetcode.i1611DivingBoardLcci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void divingBoard() {
        assertArrayEquals(new int[]{}, solution.divingBoard(1,1,0));
        assertArrayEquals(new int[]{3,4,5,6}, solution.divingBoard(1,2,3));
    }
}