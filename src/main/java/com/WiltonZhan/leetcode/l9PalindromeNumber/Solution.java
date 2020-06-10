package com.WiltonZhan.leetcode.l9PalindromeNumber;

import java.util.ArrayList;
import java.util.List;

/*
9. 回文数
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？
 */
public class Solution {
    /**
     * 方法一：转为字符串再判断
     */
    public boolean isPalindrome_str(int x) {
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    /**
     *  方法二：不转为字符串，用列表存放x的每一位，然后判断。
     *  121 -> 12 -> 1 -> 0
     */
    public boolean isPalindrome_list(int x) {
        if (x < 0) {
            return false;
        }

        List<Integer> digits = new ArrayList<>();
        while (x != 0) {
            digits.add(x % 10);
            x /= 10;
        }

        int l = 0, r = digits.size() - 1;
        while (l < r) {
            if (!digits.get(l++).equals(digits.get(r--))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法三：只反转数字的一半。
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int halfRevertedNumber = 0;
        while (x > halfRevertedNumber) {
            halfRevertedNumber = halfRevertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == halfRevertedNumber || x == halfRevertedNumber / 10; // 分别判断原数字长度是奇数或偶数的情况
    }
}
