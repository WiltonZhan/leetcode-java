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
    public int superEggDrop1(int K, int N) {
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
    
    /**
     ** 假设我们有K个鸡蛋，并且可以扔T次。那么原来的问题可以转化为：我们可以测试到的最高楼层是多少。
     * 假设memo(T,K)表示在有K个鸡蛋并且可以扔T次的情况下能测试的最高楼层。先求出所有的memo(T,K)，然后找出满足memo(T,K)≥F的T的最小值。
     * 利用动态规划：考虑扔出一个鸡蛋后可能出现的两种情况：
     *  1. 鸡蛋碎了：可以测试到的最高楼层是memo(T-1,K-1)。
     *  2. 鸡蛋没碎：可以测试到的最高楼层是memo(T-1,K)。
     * 因此状态转移方程为：memo(T,K) = memo(T-1,K-1) + memo(T-1,K) + 1。
     *
     * 现在考虑初始条件：
     *  1. 当只有一个鸡蛋时，对于任意的T(T≥1)，memo(T,1) = T，即只能从最低层往最高层一层一层地扔。
     *  2. 当只能扔一次时，无论有多少个鸡蛋，memo(1,K) = 1。
     * 条件1间接的告诉了我们：在最坏的情况下，找到目标楼层所需要扔鸡蛋的次数。
     *
     * @param K   鸡蛋数
     * @param N    楼层数
     * @return  最坏情况下测出结果锁妖扔鸡蛋的次数
     */
    public int superEggDrop(int K, int N) {
        if (N == 1) {
            return 1;
        }

        int[][] memo = new int[N + 1][K + 1];
        for (int k = 1; k <= K; k++) {
            memo[1][k] = 1;
        }

        for (int t = 2; t <= N; t++) {
            for (int k = 1; k <= K; k++) {
                memo[t][k] = memo[t - 1][k - 1] + memo[t - 1][k] + 1;
            }
            if (memo[t][K] >= N) {
                return t;
            }
        }

        return -1;
    }
}
