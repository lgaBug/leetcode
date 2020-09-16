package com.lga.algorithm.tag.dp;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/description/
 */
public class Rob {

    public int rob(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int len = nums.length;
        int[] cache1 = new int[len - 1];
        Arrays.fill(cache1, -1);
        int[] cache2 = new int[len - 1];
        Arrays.fill(cache2, -1);

        return Math.max(opt(Arrays.copyOfRange(nums, 0, len - 1), len - 2, cache1), opt(Arrays.copyOfRange(nums, 1, len), len - 2, cache2));
    }

    private int opt(int[] nums, int n, int[] cache) {

        if (cache[n] != -1) return cache[n];

        if (n == 0) {
            cache[n] = nums[0];
            return nums[0];
        }
        if (n == 1) {
            int max = Math.max(nums[0], nums[1]);
            cache[n] = max;
            return max;
        }
        int max = Math.max(opt(nums, n - 1, cache), opt(nums, n - 2, cache) + nums[n]);
        cache[n] = max;
        return max;
    }


    public int rob_dp(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(nums,0,nums.length-1),myRob(nums,1,nums.length));
    }
    private int myRob(int[] nums,int start,int end) {
        int prevMax = 0;
        int currMax = 0;
        for(int i=start;i<end;i++){
            int temp = currMax;
            currMax = Math.max(nums[i]+prevMax, currMax);
            prevMax = temp;
        }
        return currMax;
    }


}
