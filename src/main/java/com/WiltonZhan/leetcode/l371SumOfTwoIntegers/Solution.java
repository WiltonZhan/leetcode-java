package com.WiltonZhan.leetcode.l371SumOfTwoIntegers;

/*
不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

示例 1:

输入: a = 1, b = 2
输出: 3
示例 2:

输入: a = -2, b = 3
输出: 1
 */
public class Solution {
    /**
     *  1. 异或查看两个数进行加法操作后的结果
     *  2. 与运算计算出想对应的位置的进位结果，然后左移一位
     *  3. 看进位位置，若为1，则继续，否则结束
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
