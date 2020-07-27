package com.WiltonZhan.leetcode.lcof11XuanZhuanShuZuDeZuiXiaoShuZi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void minArray() {
        assertEquals(1, solution.minArray(new int[]{1,2,3,4,5}));
        assertEquals(1, solution.minArray(new int[]{3,4,5,1,2}));
        assertEquals(0, solution.minArray(new int[]{2,2,2,0,1}));
    }
}