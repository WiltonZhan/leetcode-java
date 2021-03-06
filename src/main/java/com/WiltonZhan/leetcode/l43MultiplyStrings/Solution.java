package com.WiltonZhan.leetcode.l43MultiplyStrings;

/*
43. 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Solution {
    /**
     * 模拟手工乘法
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return null;
        }
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }

        int len1 = num1.length(), len2 = num2.length();
        String result = "";
        for (int i = len1 - 1; i >= 0; i--) {
            StringBuilder cur = new StringBuilder();
            int carry = 0;
            for (int j = len1 - 1; j > i; j--) {
                cur.append('0');
            }
            int a = num1.charAt(i) - '0';

            for (int j = len2 - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int product = a * b + carry;
                cur.append(product % 10);
                carry = product / 10;
            }

            if (carry != 0) {
                cur.append(carry);
            }

            result = addStrings(result, cur.reverse().toString());
        }

        return result;
    }

    /**
     *  手工加法
     */
    private String addStrings(String num1, String num2) {
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
