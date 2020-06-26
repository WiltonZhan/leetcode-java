package com.WiltonZhan.leetcode.i1719MissingTwoLcci;

/*
面试题 17.19. 消失的两个数字
给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？

以任意顺序返回这两个数字均可。

示例 1:

输入: [1]
输出: [2,3]
示例 2:

输入: [2,3]
输出: [1,4]
提示：

nums.length <= 30000
 */
public class Solution {
    /**
     *  为了在 O(N) 时间内只用 O(1) 的空间找到缺失的两个数字，只能对数组进行常数次遍历，且只能存储常数个变量。
     *
     *  解方程
     */
    public int[] missingTwo(int[] nums) {
        if (nums == null) {
            return null;
        }

        int len = nums.length;
        int N = nums.length + 2;

        // 方程1
        int sum1 = N * (N + 1) / 2;
        for (int num: nums) {
            sum1 -= num;
        }

        // 方程2
        int sum2 = (N - 1) * (N - 1) + (N * N);
        for (int i = 0; i < len; i++) {
            sum2 += (i + 1) * (i + 1);
            sum2 -= nums[i] * nums[i];
        }

        // 解方程
        int product = (sum1 * sum1 - sum2) / 2;
        for (int a = 1; a < sum1; a++) {
            int b = sum1 - a;
            if (a * b == product) {
                return new int[]{a, b};
            }
        }

        return null;
    }
}
