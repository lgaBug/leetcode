package com.lga.algorithm.tag.medium._560;

/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class SubarraySum {

    /**
     * 暴力法
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len;j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        SubarraySum solution = new SubarraySum();
        int res = solution.subarraySum(nums, k);
        System.out.println(res);
    }
}
