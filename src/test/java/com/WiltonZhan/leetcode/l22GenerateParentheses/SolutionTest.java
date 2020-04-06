package com.WiltonZhan.leetcode.l22GenerateParentheses;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void generateParenthesis() {
        List<String> combinations1 = solution.generateParenthesis(3);
        Collections.sort(combinations1);
        String[] expected1 = new String[]{"((()))", "(()())", "(())()", "()(())", "()()()"};
        assertEquals(combinations1.size(), expected1.length);
        for (int i = 0; i < combinations1.size(); i++) {
            assertEquals(combinations1.get(i), expected1[i]);
        }
    }
}