package com.WiltonZhan.leetcode.l174DungeonGame;

/*
174. 地下城游戏
一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。

骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。

有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。

为了尽快到达公主，骑士决定每次只向右或向下移动一步。



编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。

例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。

-2 (K)	-3	 3
-5	    -10	 1
10	    30	-5 (P)


说明:

骑士的健康点数没有上限。

任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 */
public class Solution {
    /**
     *  动态规划：用hp[i][j]表示骑士从dungeon[i][j]到终点所需要的最低初始HP。换句话说，当到达dungeon[i][j]时，如果我们的路径和不小于hp[i][j]，
     *      那么我们就能到达终点。
    */
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 0;
        }
        int M = dungeon.length, N = dungeon[0].length;
        int[][] hp = new int[M][N];
        if (dungeon[M - 1][N - 1] >= 0) {
            hp[M - 1][N - 1] = 1;
        } else {
            hp[M - 1][N - 1] = 1 - dungeon[M - 1][N - 1];
        }
        for (int m = M - 2; m >= 0; m--) {
            hp[m][N - 1] = Math.max(hp[m + 1][N - 1] - dungeon[m][N - 1], 1);
        }
        for (int n = N - 2; n >= 0; n--) {
            hp[M - 1][n] = Math.max(hp[M - 1][n + 1] - dungeon[M - 1][n], 1);
        }

        for (int m = M - 2; m >= 0; m--) {
            for (int n = N - 2; n >= 0; n--) {
                hp[m][n] = Math.max(Math.min(hp[m + 1][n], hp[m][n + 1]) - dungeon[m][n], 1);
            }
        }

        return hp[0][0];
    }
}
