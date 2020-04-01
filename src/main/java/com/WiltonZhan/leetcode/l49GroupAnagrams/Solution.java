package com.WiltonZhan.leetcode.l49GroupAnagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> groups = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (groups.containsKey(sortedStr)) {
                groups.get(sortedStr).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                groups.put(sortedStr, strList);
            }
        }

        return new ArrayList<>(groups.values());
    }
}
