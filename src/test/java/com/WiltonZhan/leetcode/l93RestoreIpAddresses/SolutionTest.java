package com.WiltonZhan.leetcode.l93RestoreIpAddresses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void restoreIpAddresses() {
        assertArrayEquals(new String[]{"0.10.0.10","0.100.1.0"}, solution.restoreIpAddresses("010010").toArray());
        assertArrayEquals(new String[]{"0.0.0.0"}, solution.restoreIpAddresses("0000").toArray());
        assertArrayEquals(new String[]{"255.255.11.135", "255.255.111.35"}, solution.restoreIpAddresses("25525511135").toArray());
    }
}