package com.WiltonZhan.leetcode.l126WordLadderII;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void findLadders() {
        List<List<String>> wordLadder;
        wordLadder = solution.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        assertEquals(2, wordLadder.size());
        assertArrayEquals(new String[]{"hit","hot","dot","dog","cog"}, wordLadder.get(0).toArray());
        assertArrayEquals(new String[]{"hit","hot","lot","log","cog"}, wordLadder.get(1).toArray());

        assertEquals(0, solution.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")).size());

        assertEquals(1, solution.findLadders("a", "c", Arrays.asList("a","b","c")).size());
        assertEquals(0, solution.findLadders("hot", "dog", Arrays.asList("hot","dog")).size());
    }
}