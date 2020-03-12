package com.WiltonZhan.leetcode.l887SupperEggDrop;

/**
 * see: https://github.com/Shellbye/Shellbye.github.io/issues/4
 */
public class Solution {
    /**
     * 假设从n楼开始测试，则N层楼被分成了[0, n]和[n + 1, N]两部分。递归测试
     * searchTime(K, N) = max(searchTime(K-1, X-1), searchTime(K, N-X))
     *
     * @param K 鸡蛋个数
     * @param N 楼层数
     * @return  确定F的最小移动次数
     */
    public int superEggDrop(int K, int N) {
        int[][] middleResults = new int[K + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            middleResults[0][i] = 0;    // 0个蛋
            middleResults[1][i] = i;    // 1个蛋，只能从下往上一个一个试
        }
        for(int i = 1; i <= K; i++) {
            middleResults[i][0] = 0;    // 0层楼
        }
        for(int k = 2; k <= K; k++) {   // 2~K个蛋依次遍历
            for(int n = 1; n <= N; n++) {   // 1~N层楼依次遍历
                int drops = N * N;
                for (int x = 1; x <= n; x++) {  // 1~n层楼依次遍历
                    drops = Math.min(drops, 1 + Math.max(middleResults[k - 1][x - 1], middleResults[k][n - x]));
                }
                middleResults[k][n] = drops;
            }
        }
        return middleResults[K][N];
    }
}
