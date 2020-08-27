package com.WiltonZhan.leetcode.l332ReconstructItinerary;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void findItinerary() {
        List<List<String>> tickets1 = Arrays.asList(
            Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO")
        );
        assertArrayEquals(new String[]{"JFK", "MUC", "LHR", "SFO", "SJC"}, solution.findItinerary(tickets1).toArray());

        List<List<String>> tickets2 = Arrays.asList(
        Arrays.asList("JFK","SFO"), Arrays.asList("JFK","ATL"),Arrays.asList("SFO","ATL"),Arrays.asList("ATL","JFK"),Arrays.asList("ATL","SFO")
        );
        assertArrayEquals(new String[]{"JFK","ATL","JFK","SFO","ATL","SFO"}, solution.findItinerary(tickets2).toArray());
    }
}