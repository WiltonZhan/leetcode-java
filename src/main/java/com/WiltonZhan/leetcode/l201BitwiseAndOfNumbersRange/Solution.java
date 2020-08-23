package com.WiltonZhan.leetcode.l201BitwiseAndOfNumbersRange;

/*
201. 数字范围按位与
给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

示例 1:

输入: [5,7]
输出: 4
示例 2:

输入: [0,1]
输出: 0
 */
public class Solution {
    /**
     *  超时
     */
    public int rangeBitwiseAnd1(int m, int n) {
        if (m == 0) {
            return 0;
        }

        int result = m;
        for (int i = m + 1; i <= n; i++) {
            result &= i;
        }
        return result;
    }


    /**
     * 超时
     */
    public int rangeBitwiseAnd2(int m, int n) {
        if (m == n || m + 1 == n) {
            return m & n;
        }

        int mid = m + (n - m) / 2;
        return rangeBitwiseAnd(m, mid) & rangeBitwiseAnd(mid + 1, n);
    }


    /**
     * 对所有数字执行按位与运算的结果是所有对应二进制字符串的公共前缀再用零补上后面的剩余位。
     * 所有这些二进制字符串的公共前缀也即指定范围的起始和结束数字 m 和 n 的公共前缀。
     * 因此，最终我们可以将问题重新表述为：给定两个整数，我们要找到它们对应的二进制字符串的公共前缀。
     *
     * 将两个数字不断向右移动，直到数字相等，即数字被缩减为它们的公共前缀。然后，通过将公共前缀向左移动，将零添加到公共前缀的右边以获得最终结果。
     *
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;

        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }

        return m << shift;
    }
}
