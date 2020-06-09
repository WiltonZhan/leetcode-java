package com.WiltonZhan.leetcode.i46BaShuZiFanYiChengZiFuChuanLcof;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void translateNum() {
        assertEquals(4, solution.translateNum(18822));
        assertEquals(1, solution.translateNum(506));
        assertEquals(1, solution.translateNum(26));
        assertEquals(5, solution.translateNum(12258));
    }
}