package com.WiltonZhan.leetcode.i11XuanZhuanShuZuDeZuiXiaoShuZiLcof;

/*
剑指 Offer 11. 旋转数组的最小数字
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

示例 1：

输入：[3,4,5,1,2]
输出：1
示例 2：

输入：[2,2,2,0,1]
输出：0
注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Solution {
    /**
     *  考虑旋转数组的两种情况：
     *      1. 旋转0个元素：原数组依旧有序，最小元素即为数组第一个元素
     *      2. 旋转若干个元素：原数组由两个有序数组构成，且第一个有序数组的第一个元数不小于第二个有序数组的最后一个元素
     */
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] < numbers[right]) {
                // 右侧一定是一个有序数组，目标值在左侧
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                // 目标值一定在右侧
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
