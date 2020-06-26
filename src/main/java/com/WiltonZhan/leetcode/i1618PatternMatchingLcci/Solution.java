package com.WiltonZhan.leetcode.i1618PatternMatchingLcci;

/*
面试题 16.18. 模式匹配
你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。

示例 1：

输入： pattern = "abba", value = "dogcatcatdog"
输出： true
示例 2：

输入： pattern = "abba", value = "dogcatcatfish"
输出： false
示例 3：

输入： pattern = "aaaa", value = "dogcatcatdog"
输出： false
示例 4：

输入： pattern = "abba", value = "dogdogdogdog"
输出： true
解释： "a"="dogdog",b=""，反之也符合规则
提示：

0 <= len(pattern) <= 1000
0 <= len(value) <= 1000
你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 */
public class Solution {
    /**
     * 蛮力法：先确定a，再尝试b。需要剪枝，否则会超时
     */
    public boolean patternMatching(String pattern, String value) {
        if(pattern == null || value == null) {
            return false;
        }
        if (value.length() == 0) {
            return !(pattern.contains("a") && pattern.contains("b"));
        }

        // 替换成以字母a开头的模式
        if (pattern.startsWith("b")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pattern.length(); i++) {
                switch (pattern.charAt(i)) {
                    case 'a':
                        sb.append('b');
                        break;
                    case 'b':
                        sb.append('a');
                }
            }
            pattern = sb.toString();
        }

        for (int i = 0; i <= value.length(); i++) {
            String a = value.substring(0, i);
            StringBuilder prefix = new StringBuilder();
            int j = 0;
            while (j < pattern.length() && pattern.charAt(j) == 'a') {
                prefix.append(a);
                if (prefix.length() > value.length()) { // 剪枝
                    return false;
                }
                j++;
            }
            int pl = prefix.length();
            for (int k = pl; k <= value.length(); k++) {
                StringBuilder suffix = new StringBuilder();
                String b = value.substring(pl, k);
                for (int t = j; t < pattern.length(); t++) {
                    switch (pattern.charAt(t)) {
                        case 'b':
                            suffix.append(b);
                            break;
                        case 'a':
                            suffix.append(a);
                    }
                    if (pl + suffix.length() > value.length()) {    // 剪枝
                        break;
                    }
                }

                if ((prefix.toString() + suffix.toString()).equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }
}
