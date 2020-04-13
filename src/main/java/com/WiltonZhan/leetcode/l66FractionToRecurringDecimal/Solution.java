package com.WiltonZhan.leetcode.l66FractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

/*
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

如果小数部分为循环小数，则将循环的部分括在括号内。

示例 1:

输入: numerator = 1, denominator = 2
输出: "0.5"
示例 2:

输入: numerator = 2, denominator = 1
输出: "2"
示例 3:

输入: numerator = 2, denominator = 3
输出: "0.(6)"
 */
public class Solution {
    /**
     *  模仿手工除法。若一个分数代表的小数不能被除尽，那么它肯定是一个循环小数。
     *  当余数开始重复时，商也会开始重复
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        if (numerator == 0) {
            return "0";
        }

        StringBuilder fraction = new StringBuilder();
        if ((numerator < 0)^(denominator < 0)) {
            fraction.append('-');
        }
        long n = Math.abs(Long.valueOf(numerator));
        long d = Math.abs(Long.valueOf(denominator));
        fraction.append(n / d);
        long remainder = n % d;
        if(remainder == 0) {
            return fraction.toString();
        }
        fraction.append('.');
        // 使用map记录当前余数对应的fraction中商的位置，便于后续发现循环后插入'('
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(')');
                return fraction.toString();
            }
            map.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / d);
            remainder %= d;
        }

        return fraction.toString();
    }
}
