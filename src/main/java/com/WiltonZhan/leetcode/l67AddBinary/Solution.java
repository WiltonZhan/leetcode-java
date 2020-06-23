package com.WiltonZhan.leetcode.l67AddBinary;

/*
67. 二进制求和
给你两个二进制字符串，返回它们的和（用二进制表示）。

输入为 非空 字符串且只包含数字 1 和 0。



示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"


提示：

每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。
 */
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return null;
        }

        int carry = 0;
        StringBuilder sum = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int bitSum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            switch (bitSum) {
                case 0:
                    carry = 0;
                    sum.append('0');
                    break;
                case 1:
                    carry = 0;
                    sum.append('1');
                    break;
                case 2:
                    carry = 1;
                    sum.append('0');
                    break;
                case 3:
                    carry = 1;
                    sum.append('1');
            }
        }
        if (carry == 0) {
            for (; i >= 0; i--) {
                sum.append(a.charAt(i));
            }
            for (; j>= 0; j--) {
                sum.append(b.charAt(j));
            }
        } else {
            carry = calculateRest(a, carry, sum, i);
            carry = calculateRest(b, carry, sum, j);
            if (carry != 0) {   // carry == 1
                sum.append(carry);
            }
        }

        return sum.reverse().toString();
    }

    private int calculateRest(String s, int carry, StringBuilder sum, int j) {
        for (; j >= 0; j--) {
            int bitSum = (s.charAt(j) - '0') + carry;
            switch (bitSum) {
                case 0:
                    carry = 0;
                    sum.append('0');
                    break;
                case 1:
                    carry = 0;
                    sum.append('1');
                    break;
                case 2:
                    carry = 1;
                    sum.append('0');
            }
        }
        return carry;
    }

    /**
     * 字符串太长时可能出现NumberFormatException
     */
    public String addBinary_nfe(String a, String b) {
        if (a == null || b == null) {
            return null;
        }
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
}
