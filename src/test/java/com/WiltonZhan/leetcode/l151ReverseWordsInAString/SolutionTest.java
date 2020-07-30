package com.WiltonZhan.leetcode.l151ReverseWordsInAString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void reverseWords() {
        assertEquals("", solution.reverseWords("     "));
        assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
        assertEquals("world! hello", solution.reverseWords("  hello world!  "));
        assertEquals("example good a", solution.reverseWords("a good   example"));
    }
}