package com.WiltonZhan.leetcode.l278FirstBadVersion;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        while (l < n) {
            int m = l + (n - l) / 2;
            if (isBadVersion(m)) {
                n = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}

