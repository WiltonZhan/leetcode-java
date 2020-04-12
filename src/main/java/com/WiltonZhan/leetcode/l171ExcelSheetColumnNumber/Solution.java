package com.WiltonZhan.leetcode.l171ExcelSheetColumnNumber;

/*
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701
 */
public class Solution {
    /**
     *  以ZY为例：Y->25,Z-26，ZY = 26 * 26 + 25 = 26 * 26^1 + 25 * 26^0 = 701;
     */
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            int pow = 1;
            for (int j = len - i - 1; j > 0; j--) {
                pow *= 26;
            }
            result += (s.charAt(i) - 'A' + 1) * pow;
        }

        return result;
    }
}
