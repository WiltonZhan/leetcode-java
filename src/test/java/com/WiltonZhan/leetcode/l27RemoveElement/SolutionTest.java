package com.WiltonZhan.leetcode.l27RemoveElement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void removeElement() {
        assertEquals(2, solution.removeElement(new int[]{3,2,2,3}, 3));
        assertEquals(5, solution.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}