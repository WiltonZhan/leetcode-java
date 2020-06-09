package com.WiltonZhan.leetcode.i46BaShuZiFanYiChengZiFuChuanLcof;

/*
面试题46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。



示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"


提示：

0 <= num < 2^31
 */
public class Solution {
    /**
     * 动态规划：开辟一个数组memo，memo[i]表示以第i个数字结尾的前缀的不同翻译数量。
     *
     * 12258:
     *  1 -> 1: "1"
     *  12 -> 2: "1+2","12"
     *  122 -> 3: "1+2+2","12+2","1+22"
     *  1225 -> 5: "1+2+2+5","12+2+5","1+22+5","12+25","1+2+25"
     *  12258 -> 5: "1+2+2+5+8","12+2+5+8","1+22+5+8","12+25+8","1+2+25+8"
     */
    public int translateNum_more_extra_space(int num) {
        if (num < 10) {
            return 1;
        }
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int[] memo = new int[len];
        memo[0] = 1;
        int t = (numStr.charAt(0) - '0') * 10 + (numStr.charAt(1) - '0');
        if (t > 9 && t < 26) {
            memo[1] = 2;
        } else {
            memo[1] = 1;
        }
        for (int i = 2; i < len; i++) {
            t = (numStr.charAt(i - 1) - '0') * 10 + (numStr.charAt(i) - '0');
            if (t > 9 && t < 26) {
                memo[i] = memo[i - 1] + memo[i - 2];
            } else {
                memo[i] = memo[i - 1];
            }
        }

        return memo[len - 1];
    }

    /**
     * 改进：使用常数额外空间
     */
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int first = 1, two = 1;
        int t = (numStr.charAt(0) - '0') * 10 + (numStr.charAt(1) - '0');
        if (t > 9 && t < 26) {
            two = 2;
        }
        int ans = two;
        for (int i = 2; i < len; i++) {
            t = (numStr.charAt(i - 1) - '0') * 10 + (numStr.charAt(i) - '0');
            if (t > 9 && t < 26) {
                ans = first + two;
            } else {
                ans = two;
            }
            first = two;
            two = ans;
        }

        return ans;
    }
}
