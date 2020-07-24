package com.WiltonZhan.leetcode.l1025DivisorGame;

/*
1025. 除数博弈
爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。

最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：

选出任一 x，满足 0 < x < N 且 N % x == 0 。
用 N - x 替换黑板上的数字 N 。
如果玩家无法执行这些操作，就会输掉游戏。

只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。



示例 1：

输入：2
输出：true
解释：爱丽丝选择 1，鲍勃无法进行操作。
示例 2：

输入：3
输出：false
解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。


提示：

1 <= N <= 1000
 */
public class Solution {
    /**
     * 找规律：
     * <ul>
     *     <li>N = 1: Alice fail</li>
     *     <li>N = 2: Alice get 1, Bob fail</li>
     *     <li>N = 3: Alice has no choice but get 1, Alice fail</li>
     *     <li>N = 4: Alice get 1, Bob fail</li>
     *     <li>N = 5: Alice has no choice but get 1, Alice fail</li>
     *     <li>N = 6: Alice get 3, Bob fail</li>
     * </ul>
     *
     * 当N为偶数时，先手方获胜。这可以通过归纳法证明
     *
     */
    public boolean divisorGame_1(int N) {
        return N % 2 == 0;
    }

    /**
     * 动态规划：用dp[i]表示先手玩家是否一定会获胜。当当前玩家拿走一个数之后，状态变为dp[j](0 < j < i)，此时只需要枚举j，看是否存在一个j一定会使玩家失败，
     * 当前玩家使下一个状态处于必败状态就能获胜
     */
    public boolean divisorGame(int N) {
        if (N < 2) {
            return false;
        }
        boolean[] dp = new boolean[N + 1];
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if ((i % j == 0) && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}
