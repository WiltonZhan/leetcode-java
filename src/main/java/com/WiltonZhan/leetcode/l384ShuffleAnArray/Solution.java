package com.WiltonZhan.leetcode.l384ShuffleAnArray;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private final int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < copy.length; i++) {
            int temp = copy[i];
            int j = new Random().nextInt(copy.length - i) + i;
            copy[i] = copy[j];
            copy[j] = temp;
        }
        return copy;
    }
}
