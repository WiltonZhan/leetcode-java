package com.WiltonZhan.leetcode.l387FirstUniqueCharacterInAString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void firstUniqChar() {
        assertEquals(solution.firstUniqChar("leetcode"), 0);
        assertEquals(solution.firstUniqChar("loveleetcode"), 2);
        assertEquals(solution.firstUniqChar("leetcodeleetcode"), -1);
    }
}