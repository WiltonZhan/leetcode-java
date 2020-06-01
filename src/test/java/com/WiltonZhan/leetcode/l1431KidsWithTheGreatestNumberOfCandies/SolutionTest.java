package com.WiltonZhan.leetcode.l1431KidsWithTheGreatestNumberOfCandies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void kidsWithCandies() {
        assertArrayEquals(new Boolean[]{true,true,true,false,true}, solution.kidsWithCandies(new int[]{2,3,5,1,3},3).toArray());
        assertArrayEquals(new Boolean[]{true,false,false,false,false}, solution.kidsWithCandies(new int[]{4,2,1,1,2},1).toArray());
        assertArrayEquals(new Boolean[]{true,false,true}, solution.kidsWithCandies(new int[]{12,1,12},10).toArray());
    }
}