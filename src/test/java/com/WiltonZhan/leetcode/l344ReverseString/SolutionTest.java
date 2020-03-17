package com.WiltonZhan.leetcode.l344ReverseString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void reverseString() {
        char[] s1 = new char[]{'h','e','l','l','o'};
        solution.reverseString(s1);
        assertArrayEquals(s1, new char[]{'o','l','l','e','h'});

        char[] s2 = new char[]{'h','a','n','n','a','h'};
        solution.reverseString(s2);
        assertArrayEquals(s2, new char[]{'h','a','n','n','a','h'});
    }
}