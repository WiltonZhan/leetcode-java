package com.WiltonZhan.leetcode.l17LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution {
    private String[] letterMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

//        combine_string(digits, 0, "", combinations);
        combine(digits, 0, new StringBuilder(), combinations);

        return combinations;
    }

    // beat: 30.37%
    private void combine_string(String digits, int index, String str, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(str);
            return;
        }

        String s = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            combine_string(digits, index + 1, str + s.charAt(i), combinations);
        }
    }

    // beat: 100%
    private void combine(String digits, int index, StringBuilder sb, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(sb.toString());
            return;
        }

        String s = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            combine(digits, index + 1, sb.append(s.charAt(i)), combinations);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
