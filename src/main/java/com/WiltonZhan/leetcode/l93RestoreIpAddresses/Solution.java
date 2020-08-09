package com.WiltonZhan.leetcode.l93RestoreIpAddresses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。



示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        LinkedList<Integer> subResult = new LinkedList<>();
        dfs(result, subResult, s, 0);
        return result;
    }

    private void dfs(List<String> result, List<Integer> subResult, String s, int start) {
//        System.out.println("result=" + result + ", subResult=" + subResult + ", start=" + start);
        if (subResult.size() == 4 && start == s.length()) {
            StringBuilder ip = new StringBuilder();
            for (Integer sr : subResult) {
                ip.append(sr).append('.');
            }
            ip.deleteCharAt(ip.length() - 1);
            result.add(ip.toString());
            return;
        }

        if (subResult.size() == 4 || start >= s.length()) {
            return;
        }

        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            if (i != 1 && s.charAt(start) == '0') {
                return;
            }
            String num = s.substring(start, start + i);
            int address = Integer.parseInt(num);
            if (i == 3 && address > 255) {
                return;
            }
            subResult.add(address);
            dfs(result, subResult, s, start + i);
            subResult.remove(subResult.size() - 1);
        }
    }
}
