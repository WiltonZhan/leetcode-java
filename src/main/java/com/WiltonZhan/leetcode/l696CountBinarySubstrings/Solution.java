package com.WiltonZhan.leetcode.l696CountBinarySubstrings;

import java.util.ArrayList;
import java.util.List;

/*
696. 计数二进制子串
给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。

重复出现的子串要计算它们出现的次数。

示例 1 :

输入: "00110011"
输出: 6
解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。

请注意，一些重复出现的子串要计算它们出现的次数。

另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
示例 2 :

输入: "10101"
输出: 4
解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
注意：

s.length 在1到50,000之间。
s 只包含“0”或“1”字符。
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        if (s == null || s.length() <= 1) {
            return ans;
        }
        int len = s.length();
        List<Integer> zeroInZeroOnList = new ArrayList<>();
        List<Integer> oneInZeroOneList = new ArrayList<>();
        List<Integer> zeroInOneZeroList = new ArrayList<>();
        List<Integer> oneInOneZeroList = new ArrayList<>();
        for (int i = 0; i + 1 < len; i++) {
            // "01"
            if ((s.charAt(i) == '0' && s.charAt(i + 1) == '1')) {
                zeroInZeroOnList.add(i);
                oneInZeroOneList.add(i + 1);
                ans++;
            }
            // "10"
            if ((s.charAt(i) == '1' && s.charAt(i + 1) == '0')) {
                oneInOneZeroList.add(i);
                zeroInOneZeroList.add(i + 1);
                ans++;
            }
        }

        // Extend "01"
        int size = zeroInZeroOnList.size();
        for (int i = 0; i < size; i++) {
            int zero = zeroInZeroOnList.get(i);
            int one = oneInZeroOneList.get(i);
            for (int j = 1; zero - j >= 0 && one + j < len; j++) {
                if (s.charAt(zero - j) == '0' && s.charAt(one + j) == '1') {
                    ans++;
                } else {
                    break;
                }
            }
        }

        // Extend "10"
        size = oneInOneZeroList.size();
        for (int i = 0; i < size; i++) {
            int one = oneInOneZeroList.get(i);
            int zero = zeroInOneZeroList.get(i);
            for (int j = 1; one - j >= 0 && zero + j < len; j++) {
                if (s.charAt(one - j) == '1' && s.charAt(zero + j) == '0') {
                    ans++;
                } else {
                    break;
                }
            }
        }

        return ans;
    }

    /**
     * 暴力枚举，超时
     */
    public int countBinarySubstrings_brute_force(String s) {
        int ans = 0;
        if (s == null || s.length() <= 1) {
            return ans;
        }
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = 2; i + j <= len; j += 2) {
                String subStr = s.substring(i, i + j);
                if (isValid(subStr)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        if (len % 2 == 0) {
            int mid = len / 2;
            boolean zero = true;
            if (s.charAt(0) == '1') {
                zero = false;
            }
            if (zero) {
                for (int i = 0; i < mid; i++) {
                    if (s.charAt(i) != '0') {
                        return false;
                    }
                }
                for (int i = mid; i < len; i++) {
                    if (s.charAt(i) != '1') {
                        return false;
                    }
                }
            } else {
                for (int i = 0; i < mid; i++) {
                    if (s.charAt(i) != '1') {
                        return false;
                    }
                }
                for (int i = mid; i < len; i++) {
                    if (s.charAt(i) != '0') {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
