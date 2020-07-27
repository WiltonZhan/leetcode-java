package com.WiltonZhan.leetcode.lcci1611DivingBoard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
面试题 16.11. 跳水板
你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。

返回的长度需要从小到大排列。

示例：

输入：
shorter = 1
longer = 2
k = 3
输出： {3,4,5,6}
提示：

0 < shorter <= longer
0 <= k <= 100000
 */
public class Solution {
    /**
     *  枚举所有可能，用集合去重，然后排序
     */
    public int[] divingBoard_hashset(int shorter, int longer, int k) {
        if (k <= 0) {
            return new int[]{};
        }
        Set<Integer> lengths = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            lengths.add(shorter * i + (k - i) * longer);
        }
        int[] result = new int[lengths.size()];
        int j = 0;
        for (Integer length: lengths) {
            result[j++] = length;
        }
        Arrays.sort(result);

        return result;
    }

    /**
     * 利用题目的性质
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k <= 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] result = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            result[i] = longer * i + shorter * (k - i);
        }
        return result;
    }
}
