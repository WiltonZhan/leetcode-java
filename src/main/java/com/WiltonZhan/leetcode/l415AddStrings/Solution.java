package com.WiltonZhan.leetcode.l415AddStrings;

/*
415. 字符串相加
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：

num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class Solution {
    /**
     * 模拟手工加法
     */
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        int carry = 0;
        int i1 = num1.length() - 1, i2 = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        while (i1 >= 0 && i2 >= 0) {
            int sum = num1.charAt(i1) - '0' + num2.charAt(i2) - '0' + carry;
            carry = sum / 10;
            result.append(sum % 10);
            i1--;
            i2--;
        }
        while (i1 >= 0) {
            int sum = num1.charAt(i1) - '0' + carry;
            carry = sum / 10;
            result.append(sum % 10);
            i1--;
        }
        while (i2 >= 0) {
            int sum = num2.charAt(i2) - '0' + carry;
            carry = sum / 10;
            result.append(sum % 10);
            i2--;
        }
        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
