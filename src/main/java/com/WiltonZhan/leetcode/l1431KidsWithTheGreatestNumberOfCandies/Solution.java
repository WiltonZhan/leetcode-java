package com.WiltonZhan.leetcode.l1431KidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

/*
1431. 拥有最多糖果的孩子
给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。

对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。



示例 1：

输入：candies = [2,3,5,1,3], extraCandies = 3
输出：[true,true,true,false,true]
解释：
孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
示例 2：

输入：candies = [4,2,1,1,2], extraCandies = 1
输出：[true,false,false,false,false]
解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
示例 3：

输入：candies = [12,1,12], extraCandies = 10
输出：[true,false,true]


提示：

2 <= candies.length <= 100
1 <= candies[i] <= 100
1 <= extraCandies <= 50
 */
public class Solution {
    /**
     * 贪心算法：candies[i] += extraCandies, 然后检查candies[i]是否不小于其它所有的值
     * 这种写法的时间复杂度是：O(n^2)
     */
    public List<Boolean> kidsWithCandies1(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        if (candies == null || candies.length == 0) {
            return result;
        }

        for (int i = 0; i < candies.length; i++) {
            candies[i] += extraCandies;
            boolean max = true;
            for (int candy : candies) {
                if (candy > candies[i]) {
                    max = false;
                    break;
                }
            }
            result.add(max);
            candies[i] -= extraCandies;
        }

        return result;
    }

    /**
     * 两次遍历
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        if (candies == null || candies.length == 0) {
            return result;
        }

        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }

        return result;
    }
}
