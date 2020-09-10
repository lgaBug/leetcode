package com.lga.algorithm.tag.eazy._53;

/**
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/submissions/
 */
public class MaxSubArray {

    /**
     * 暴力破解， 遍历遍历所有的子集。
     * O(n^2)
     * @param nums
     * @return
     */
    public int maxSubArray_violence(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        //存储前n个数的和
        int[] preSum = new int[len + 1];
        int seq = 1;
        int tempLen = len;
        while (tempLen-->0) {
            preSum[seq] = nums[seq-1] + preSum[seq - 1];
            seq++;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                max = Math.max(max, preSum[j+1] - preSum[i]);
            }
        }

        return max;
    }


    public int maxSubArray_dp(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            }else{
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
