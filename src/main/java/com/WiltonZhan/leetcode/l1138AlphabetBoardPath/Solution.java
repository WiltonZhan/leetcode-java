package com.WiltonZhan.leetcode.l1138AlphabetBoardPath;

/*
1138. 字母板上的路径
我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。

在本题里，字母板为board = [
"abcde",
"fghij",
"klmno",
"pqrst",
"uvwxy",
"z"
]，如下所示。



我们可以按下面的指令规则行动：

如果方格存在，'U' 意味着将我们的位置上移一行；
如果方格存在，'D' 意味着将我们的位置下移一行；
如果方格存在，'L' 意味着将我们的位置左移一列；
如果方格存在，'R' 意味着将我们的位置右移一列；
'!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
（注意，字母板上只存在有字母的位置。）

返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。



示例 1：

输入：target = "leet"
输出："DDR!UURRR!!DDD!"
示例 2：

输入：target = "code"
输出："RR!DDRR!UUL!R!"


提示：

1 <= target.length <= 100
target 仅含有小写英文字母。
 */
public class Solution {
    /**
     * 将字母位置转为坐标，每次求两点之间的最短路径即可。
     */
    public String alphabetBoardPath(String target) {
        if (target == null || target.length() == 0) {
            return target;
        }

        // 建立坐标
        int[][] coordinate = new int[][]{
                {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4},
                {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4},
                {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4},
                {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4},
                {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4},
                {5, 0}
        };

        StringBuilder path = new StringBuilder();
        int pos = 0;
        for (int i = 0; i < target.length(); i++) {
            int c = target.charAt(i) - 'a';
            if (c == pos) {
                // 目标点为当前点
                path.append('!');
            } else if (c == 25) {
                // 目标点为'z'：一律先左移再下移
                int y = coordinate[pos][1];
                while (y > 0) {
                    path.append('L');
                    y--;
                }
                int x = coordinate[pos][0];
                while (x < 5) {
                    path.append('D');
                    x++;
                }
                path.append('!');
                pos = c;
            } else {
                // 目标点非'z'：先横向移动再纵向移动
                int[] targetCor = coordinate[c];
                if (pos == 25) {
                    // 当前位置在'z'：只能先上移再右移
                    for (int j = 5; j > targetCor[0]; j--) {
                        path.append('U');
                    }
                    for (int j = 0; j < targetCor[1]; j++) {
                        path.append('R');
                    }
                } else {
                    if (coordinate[pos][0] < targetCor[0]) {
                        for (int j = coordinate[pos][0]; j < targetCor[0]; j++) {
                            path.append('D');
                        }
                    } else if (coordinate[pos][0] > targetCor[0]) {
                        for (int j = coordinate[pos][0]; j > targetCor[0]; j--) {
                            path.append('U');
                        }
                    }

                    if (coordinate[pos][1] < targetCor[1]) {
                        for (int j = coordinate[pos][1]; j < targetCor[1]; j++) {
                            path.append('R');
                        }
                    } else if (coordinate[pos][1] > targetCor[1]) {
                        for (int j = coordinate[pos][1]; j > targetCor[1]; j--) {
                            path.append('L');
                        }
                    }

                }
                path.append('!');
                pos = c;
            }
        }

        return path.toString();
    }
}
