package com.WiltonZhan.leetcode.l1018BinaryPrefixDivisibleBy5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final  Solution solution = new Solution();

    @Test
    void prefixesDivBy5() {
        assertArrayEquals(new Boolean[]{true, false, false}, solution.prefixesDivBy5(new int[]{0,1,1}).toArray());
        assertArrayEquals(new Boolean[]{false, false, false}, solution.prefixesDivBy5(new int[]{1,1,1}).toArray());
        assertArrayEquals(new Boolean[]{true,false,false,false,true,false}, solution.prefixesDivBy5(new int[]{0,1,1,1,1,1}).toArray());
        assertArrayEquals(new Boolean[]{false,false,false,false,false}, solution.prefixesDivBy5(new int[]{1,1,1,0,1}).toArray());
        assertArrayEquals(new Boolean[]{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,true,true,true,true,false},
                solution.prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}).toArray());
    }
}