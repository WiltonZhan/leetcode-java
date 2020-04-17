package com.WiltonZhan.leetcode.l621TaskScheduler;

import java.util.*;

/*
给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。

然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。

你需要计算完成所有任务所需要的最短时间。



示例 ：

输入：tasks = ["A","A","A","B","B","B"], n = 2
输出：8
解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。


提示：

任务的总个数为 [1, 10000]。
n 的取值范围为 [0, 100]。
 */
public class Solution {
    /**
     * 贪心算法：给每个任务后面空出n个空间来，然后用其它任务来填充这些空间。
     * 这需要统计每个任务的数量，并对任务按照数量进行排序，优先安排数量最多的任务。
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0 || n < 0) {
            return 0;
        }

        int[] frequency = new int[26];
        for (char c: tasks) {
            frequency[c - 'A']++;
        }

        int taskCount = 0;
        for (int value : frequency) {
            if (value > 0) {
                taskCount++;
            }
        }
        int[] map = new int[taskCount];
        Arrays.sort(frequency);
        for (int i = frequency.length - taskCount, j = 0; j < taskCount; i++, j++) {
            map[j] = frequency[i];
        }

        int time = 0;
        while (map[taskCount - 1] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[taskCount - 1] == 0) {
                    break;
                }
                if (i < taskCount && map[taskCount - i - 1] > 0) {
                    map[taskCount - i - 1]--;
                }
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
}
