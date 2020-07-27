package com.WiltonZhan.leetcode.lcof64Qiu12n;

/*
面试题64. 求1+2+…+n
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。



示例 1：

输入: n = 3
输出: 6
示例 2：

输入: n = 9
输出: 45


限制：

1 <= n <= 10000
 */
public class Solution {
    /**
     * 利用递归代替条件判断
     */
    public int sumNums_recusion(int n) {
        int sum = n;

        boolean end = (n == 0) || (sum += sumNums(n - 1)) > 0;    // 利用短路运算结束递归

        return sum;
    }

    /**
     * 利用公式：1+2+3+...+n = n * (n + 1) / 2
     * 虽然表面没有使用条件判断，但是Math.pow()函数内部实现采用了条件判断
     */
    public int sumNums(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }
}
