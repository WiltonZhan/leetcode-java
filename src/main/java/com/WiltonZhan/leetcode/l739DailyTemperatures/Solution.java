package com.WiltonZhan.leetcode.l739DailyTemperatures;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
739. 每日温度
根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Solution {
    /**
     *  暴力法
     *  AC
     */
    public int[] dailyTemperatures_brute_force(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }

        int len = T.length;
        int[] days = new int[len];
        for (int i = 0; i < len; i++) {
            int j = i + 1;
            for (; j < len; j++) {
                if (T[j] > T[i]) {
                    break;
                }
            }
            days[i] = j == len ? 0 : (j - i);
        }

        return days;
    }

    /**
     * 暴力法中很多遍历是重复的，如果能够把上一次遍历中收集的信息保存下来给下一次遍历使用，应该会快一些
     */
    public int[] dailyTemperatures_memo(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }

        int len = T.length;
        int[] days = new int[len];
        int[] next = new int[101];  // 记录每个温度第一次出现的下标
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = len - 1; i >= 0; i--) {
            int warmerIndex = Integer.MAX_VALUE;
            // 找出温度更高但下标最小的那个位置
            for (int t = T[i] + 1; t <= 100; t++) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                days[i] = warmerIndex - i;
            }
            next[T[i]] = i;
        }

        return days;
    }

    /**
     * 单调栈：维护一个存储温度小标的单调栈。从栈底到栈顶元素对应的温度依次递减。如果某个温度的下标在单调栈里，则说明尚未找到下一个温度更高的下标。
     */
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }

        int len = T.length;
        int[] days = new int[len];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int j = stack.pop();
                days[j] = i - j;
            }
            stack.push(i);
        }

        return days;
    }
}
