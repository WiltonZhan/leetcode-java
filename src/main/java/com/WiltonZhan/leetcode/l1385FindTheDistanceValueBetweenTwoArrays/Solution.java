package com.WiltonZhan.leetcode.l1385FindTheDistanceValueBetweenTwoArrays;

import java.util.Arrays;

/*
1385. 两个数组间的距离值
给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。

「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。



示例 1：

输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
输出：2
解释：
对于 arr1[0]=4 我们有：
|4-10|=6 > d=2
|4-9|=5 > d=2
|4-1|=3 > d=2
|4-8|=4 > d=2
所以 arr1[0]=4 符合距离要求

对于 arr1[1]=5 我们有：
|5-10|=5 > d=2
|5-9|=4 > d=2
|5-1|=4 > d=2
|5-8|=3 > d=2
所以 arr1[1]=5 也符合距离要求

对于 arr1[2]=8 我们有：
|8-10|=2 <= d=2
|8-9|=1 <= d=2
|8-1|=7 > d=2
|8-8|=0 <= d=2
存在距离小于等于 2 的情况，不符合距离要求

故而只有 arr1[0]=4 和 arr1[1]=5 两个符合距离要求，距离值为 2
示例 2：

输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
输出：2
示例 3：

输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
输出：1


提示：

1 <= arr1.length, arr2.length <= 500
-10^3 <= arr1[i], arr2[j] <= 10^3
0 <= d <= 100
 */
public class Solution {
    /**
     * 先给arr2排序，然后使用二分搜索找到arr2中与arr1中当前遍历值最接近的那个值，然后判断是否满足距离值的定义。
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0 || d < 0) {
            return 0;
        }
        Arrays.sort(arr2);

        int distance = 0;
        for (int a1: arr1) {
            int idx = Arrays.binarySearch(arr2, a1);
            if (idx < 0) {
                idx = -(idx + 1);
                if (idx == 0) {
                    if (arr2[idx] - a1 > d) {
                        distance++;
                    }
                } else if (idx == arr2.length) {
                    if (a1 - arr2[idx - 1] > d) {
                        distance++;
                    }
                }else {
                    if (a1 - arr2[idx - 1] > d && arr2[idx] - a1 > d) {
                        distance++;
                    }
                }
            }
        }

        return distance;
    }
}
