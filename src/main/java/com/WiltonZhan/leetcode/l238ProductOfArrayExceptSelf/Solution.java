package com.WiltonZhan.leetcode.l238ProductOfArrayExceptSelf;

/*
238. 除自身以外数组的乘积
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。



示例:

输入: [1,2,3,4]
输出: [24,12,8,6]


提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
*/
public class Solution {
    /**
     * 暴力求解，时间复杂度：O(n^2)
     * AC
     */
    public int[] productExceptSelf_bruteforce(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        int[] output = new int[len];
        for (int i = 0; i < len; i++) {
            int product = 1;
            for (int j = 0; j < i; j++) {
                product *= nums[j];
            }
            for (int j = i + 1; j < len; j++) {
                product *= nums[j];
            }
            output[i] = product;
        }

        return output;
    }

    /**
     * 开辟两个数组：
     *  * prefixProduct[i]记录nums[i]的前缀乘积
     *  * suffixProduct[i]记录nums[i]的后缀乘积
     * 前两次遍历计算出prefixProduct和suffixProduct，第三次遍历计算出最终结果
     * 时间复杂度：O(3n)
     * 空间复杂度：O(2n)
     */
    public int[] productExceptSelf_2n_extra_space(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        int[] prefixProduct = new int[len], suffixProduct = new int[len], output = new int[len];

        prefixProduct[0] = 1;
        for (int i = 1; i < len; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        suffixProduct[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            output[i] = prefixProduct[i] * suffixProduct[i];
        }

        return output;
    }

    /**
     *  利用output数组临时保存前缀乘积或后缀乘积，将空间复杂度降至O(n)
     */
    public int[] productExceptSelf_1n_extra_space(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        int[] prefixProduct = new int[len], output = new int[len];

        prefixProduct[0] = 1;
        for (int i = 1; i < len; i++) {
            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        output[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            output[i] = output[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            output[i] *= prefixProduct[i];
        }

        return output;
    }

    /**
     *  利用output数组临时保存前缀乘积，第二次遍历直接原地更新nums，用nums来保存后缀乘积。
     *  将空间复杂度降至O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        int len = nums.length;
        int[] output = new int[len];

        output[0] = 1;
        for (int i = 1; i < len; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        int val = nums[len - 1];
        nums[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            int numsi = nums[i];
            nums[i] = nums[i + 1] * val;
            val = numsi;
        }

        for (int i = 0; i < len; i++) {
            output[i] *= nums[i];
        }

        return output;
    }
}
