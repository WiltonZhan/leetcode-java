package com.WiltonZhan.leetcode.l32LongestValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/*
32. 最长有效括号
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:

输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
 */
public class Solution {
    /**
     * 使用栈：保持栈底元素为最后一个没有被匹配的右括号的下标，栈中的其它元素为左括号的下标：
     *  若当前遇到的是'('，将其下标放入栈
     *  若当前遇到的是')'，先弹出栈顶元素以表示我们匹配成功：
     *      如果栈为空，则将其下标入栈
     *      否则，当前右括号的下标减去栈顶元素就是以该右括号结尾的最长有效括号的长度
     */
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }
}
