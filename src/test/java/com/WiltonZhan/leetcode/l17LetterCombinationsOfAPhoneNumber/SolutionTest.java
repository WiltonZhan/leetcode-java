package com.WiltonZhan.leetcode.l17LetterCombinationsOfAPhoneNumber;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void letterCombinations() {
        List<String> combinations1 = solution.letterCombinations("23");
        Collections.sort(combinations1);
        String[] sortedStrings1 = combinations1.toArray(new String[]{});
        String[] strings1 = new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        assertEquals(sortedStrings1.length, strings1.length);
        for (int i = 0; i < sortedStrings1.length; i++) {
            assertEquals(sortedStrings1[i], strings1[i]);
        }
    }
}