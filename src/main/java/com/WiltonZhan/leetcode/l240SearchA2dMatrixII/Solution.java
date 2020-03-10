package com.WiltonZhan.leetcode.l240SearchA2dMatrixII;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *      每行的元素从左到右升序排列。
 *      每列的元素从上到下升序排列。
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] > target) {
            return false;
        }
        // 先确定所有可能在行
        int rowStart = 0, rowEnd = 0;
        while (rowEnd < matrix.length - 1 && matrix[rowEnd][0] <= target) {
            rowEnd++;
        }
        // 然后对每一行进行二分查找
        for (int row = rowStart; row <= rowEnd; row++) {
            if (binarySearch(matrix[row], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
