package com.WiltonZhan.leetcode.l13RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = s.length();
        if (len == 1) {
            return map.get(s.charAt(0));
        }

        int value = 0;
        for (int i = 1; i < len; i++) {
            int left = map.get(s.charAt(i - 1)), right = map.get(s.charAt(i));
            if (left < right) {
                value -= left;
            } else {
                value += left;
            }
        }

        value += map.get(s.charAt(len - 1));

        return value;
    }
}
