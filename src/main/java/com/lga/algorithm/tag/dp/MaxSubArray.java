package com.lga.algorithm.tag.dp;

import org.junit.Test;

public class MaxSubArray {

//    public int maxSubArray(int[] nums) {
//        if (nums == null || nums.length <=0) return 0;
//        return f(nums, nums.length-1);
//    }
//
//    private int f(int[] nums, int n) {
//        if (n == 0) return nums[0];
//        return Math.max(f(nums, n - 1) + nums[n], nums[n]);
//    }


    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length <=0) return 0;
        return f(nums, nums.length);
    }

    private int f(int[] nums, int n) {

        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
        }
        return dp[n - 1];
    }

    @Test
    public void test() {
        maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
