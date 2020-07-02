package com.WiltonZhan.leetcode.l378KthSmallestElementInASortedMatrix;

import java.util.*;

/*
378. 有序矩阵中第K小的元素
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。



示例：

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。


提示：
你可以假设 k 的值永远是有效的，1 ≤ k ≤ n^2 。
 */
public class Solution {
    /**
     *  使用优先队列：保留k个最小的元素，遍历完矩阵后返回最大的那一个
     *  这不会利用矩阵元素有序的性质
     */
    public int kthSmallest_heap(int[][] matrix, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int n: row) {
                if (heap.size() < k) {
                    heap.offer(n);
                } else if (heap.size() == k) {
                    if (heap.peek() > n) {
                        heap.poll();
                        heap.offer(n);
                    }
                }
            }
        }

        return heap.peek();
    }

    /**
     * 开辟一个新的数组，存放下矩阵的所有元素，然后排序。
     */
    public int kthSmallest_sort(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[] nums = new int[m * n];
        int i = 0;
        for (int[] row : matrix) {
            for (int num: row) {
                nums[i++] = num;
            }
        }

        Arrays.sort(nums);
        return nums[k - 1];
    }

    /**
     * 利用矩阵行列有序的性质，进行二分查找。
     * 首先，矩阵可以看作是从左上角到右下角升序的，最小值min=matrix[0][0]，而最大值max=matrix[n-1][n-1]。第k小的数肯定在min和max中间。
     * 考虑min和max的中间值mid(mid = (min + max) / 2)，统计矩阵中小于mid的值得数量count：
     *  1. 若count < k，则说明第k小的元素位于（mid,max]中，修改min的值为mid+1。
     *  2. 否则，则说明第k小的元素位于[min,mid]中，修改max的值为mid。
     * 以上保证第k小的数一直处于[min,max]中，通过不断夹逼，最终min和max总会有一个先到达第k小的数target。如果min先到达，那么max必定大于target，此后max的值会不断通过mid更新，最终min==max==target。
     * 若max先到达target，那么min也会不断通过mid更新，最终也有min==max==target。
     * 貌似最终得到的值一定在矩阵中。
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0], max = matrix[n - 1][n - 1];
        while(min < max) {
            int mid = min + ((max - min) >> 1);
            // 统计矩阵中小于等于mid的元素数量（左上角）
            int count = 0;
            for (int[] row: matrix) {
                for (int num: row) {
                    if (num <= mid) {
                        count++;
                    } else {
                        break;
                    }
                }
            }

            if (count < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }
}
