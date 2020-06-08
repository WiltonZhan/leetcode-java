package com.WiltonZhan.leetcode.l990SatisfiabilityOfEqualityEquations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
990. 等式方程的可满足性
给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。



示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
示例 2：

输出：["b==a","a==b"]
输入：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
示例 3：

输入：["a==b","b==c","a==c"]
输出：true
示例 4：

输入：["a==b","b!=c","c==a"]
输出：false
示例 5：

输入：["c==c","b==d","x!=z"]
输出：true


提示：
    1. 1 <= equations.length <= 500
    2. equations[i].length == 4
    3. equations[i][0] 和 equations[i][3] 是小写字母
    4. equations[i][1] 要么是 '='，要么是 '!'
    5. equations[i][2] 是 '='
 */
public class Solution {
    /**
     * 并查集：先将“==”连接的形成集合，再去判断“!=”连接的是否在这些集合中
     */
    public boolean equationsPossible(String[] equations) {
        if (equations == null || equations.length == 0) {
            return false;
        }

        int[] parent = new int[26];
        for (int i = 0; i < parent.length; i++) {   // 将每个节点的根节点初始化为自己
            parent[i] = i;
        }

        List<Integer> nonEquationIndecies = new ArrayList<>();
        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            if (equation.charAt(1) == '=') {
                union(parent, equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            } else {
                nonEquationIndecies.add(i);
            }
        }

        for (int i = 0; i < nonEquationIndecies.size(); i++) {
            String nonEquation = equations[nonEquationIndecies.get(i)];
            if (find(parent, nonEquation.charAt(0) - 'a') == find(parent, nonEquation.charAt(3) - 'a')) {
                return false;
            }
        }

        return true;
    }

    private void union(int[] parent, int p, int q) {
        int i, j;
        for (i = p; i != parent[i]; i = parent[i]); // 找到节点p的根节点
        for (j = q; j != parent[j]; j = parent[j]); // 找到节点q的根节点
        parent[i] = j;
    }

    private int find(int[] parent, int val) {
        int i;
        for (i = val; i != parent[i]; i = parent[i]);
        return i;
    }
}
