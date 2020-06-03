package com.WiltonZhan.leetcode.l837New21Game;

/*
837. 新21点
爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：

爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。

当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？

示例 1：

输入：N = 10, K = 1, W = 10
输出：1.00000
说明：爱丽丝得到一张卡，然后停止。
示例 2：

输入：N = 6, K = 1, W = 10
输出：0.60000
说明：爱丽丝得到一张卡，然后停止。
在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
示例 3：

输入：N = 21, K = 17, W = 10
输出：0.73278
提示：

0 <= K <= N <= 10000
1 <= W <= 10000
如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
此问题的判断限制时间已经减少。
 */
public class Solution {
    /**
     *  动态规划：爱丽丝获胜的概率之和下一轮开始前的分数有关，因此根据得分计算概率。
     *  用dp[x]表示在得分为x的情况下开始抽数且获胜的概率，目标是求dp[0]。
     *  当K≤x≤min(N,k+W-1)时，dp[x] = 1.0
     *  当x>min(N,K+W-1)时，dp[x] = 0.0
     *
     *  dp[x] = (dp[x+1] + dp[x+2) + ... + dp[x+W])/W。因为抽到数字x+1的概率为1/W，所以W为分母
     */
    public double new21Game_timeout(int N, int K, int W) {
        if (K <= 0) {
            return 1.0;
        }

        double[] dp = new double[K + W];
        for (int i = K; i <= N && i <= K + W - 1; i++) {
            dp[i] = 1.0;
        }
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 1; j <= W; j++) {
                dp[i] += dp[i + j] / W;
            }
        }

        return dp[0];
    }

    /**
     * when 0 ≤ x ≤ K-1: dp[x] = dp[x+1] - (dp[x+1] - dp[x+W+1]) / W
     * when x = K-1: (dp[K] + dp[K+1] + ... + dp[K+W-1]) / W = (min(N,K+W-1) - K + 1) / W = min(N-K+1,W) / W
     */
    public double new21Game(int N, int K, int W) {
        if (K <= 0) {
            return 1.0;
        }

        double[] dp = new double[K + W];
        for (int i = K; i <= N && i <= K + W - 1; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }

        return dp[0];
    }
}
