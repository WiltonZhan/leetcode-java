package com.WiltonZhan.leetcode.l22GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/*
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        if (n <= 0) {
            return combinations;
        }

        backtrack("", 0, 0, n, combinations);

        return combinations;
    }

    /**
     * @param str   已生成的部分字符串
     * @param lCnt  已使用'('的个数
     * @param rCnt  已使用')'的个数
     * @param n     括号对的个数
     * @param combinations  结果
     */
    private void backtrack(String str, int lCnt, int rCnt, int n, List<String> combinations) {
        if (str.length() == 2 * n) {
            combinations.add(str);
            return;
        }

        if (lCnt < n) { // '('的个数只要小于n即可
            backtrack(str + '(', lCnt + 1, rCnt, n, combinations);
        }
        if (rCnt < lCnt) {  // ')'的个数必须不大于'('的个数
            backtrack(str + ')', lCnt, rCnt + 1, n, combinations);
        }
    }
}
