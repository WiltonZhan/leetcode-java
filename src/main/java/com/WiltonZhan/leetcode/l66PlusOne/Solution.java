package com.WiltonZhan.leetcode.l66PlusOne;

public class Solution {
    /**
     * 模拟手工加法
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{};
        }
        int incr = digits[digits.length - 1] + 1;
        digits[digits.length - 1] = incr % 10;
        int carry = incr / 10;
        for (int i = digits.length - 2; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry == 0) {
            int[] result = new int[digits.length];
            System.arraycopy(digits, 0, result, 0, digits.length);
            return result;
        } else {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
    }
}
