package com.WiltonZhan.leetcode.i16or18PatternMatchingLcci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void patternMatching() {
        assertTrue(solution.patternMatching("bbba", "xxxxxxy"));
        assertTrue(solution.patternMatching("", ""));
        assertTrue(solution.patternMatching("a", ""));
        assertTrue(solution.patternMatching("abba", "dogcatcatdog"));
        assertFalse(solution.patternMatching("abba", "dogcatcatfish"));
        assertFalse(solution.patternMatching("aaaa", "dogcatcatdog"));
        assertTrue(solution.patternMatching("abba", "dogdogdogdog"));
        assertFalse(solution.patternMatching("abbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbabbbb",
        "yxankynynxnxnxxyxyyyxxakxanaxnankyykxxannxayyyaxakyyyxxyxyyxxkxyyyyxnxxyykayyanayxayknayxyyynyxxykykyyxxykykyyxxy" +
                "kykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxy" +
                "kykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxy" +
                "kykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyykxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxy" +
                "kykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxyky" +
                "kyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyxxykykyyyxankynynxnxnxxyxyyyxxakxanaxnankyykxxannxayyyaxakyyyxxy" +
                "xyyxxkxyyyyxnxxyykayyanayxayknayxyyynyxxykykyyxxykykyyxxxykykyy"));
    }
}