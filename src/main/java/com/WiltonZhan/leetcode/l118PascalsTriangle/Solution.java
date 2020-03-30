package com.WiltonZhan.leetcode.l118PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        List<Integer> row1 = new ArrayList<>(1);
        row1.add(1);
        triangle.add(row1);
        if (numRows == 1) {
            return triangle;
        }
        List<Integer> row2 = new ArrayList<>(2);
        row2.add(1);
        row2.add(1);
        triangle.add(row2);
        if (numRows == 2) {
            return triangle;
        }

        for (int i = 3; i <= numRows; i++) {
            List<Integer> rowI = new ArrayList<>(i);
            rowI.add(1);

            List<Integer> lastRow = triangle.get(i - 2);
            int len = lastRow.size();
            for (int j = 0; j < len - 1; j++) {
               rowI.add(lastRow.get(j) + lastRow.get(j + 1));
            }

            rowI.add(1);
            triangle.add(rowI);
        }

        return triangle;
    }
}
