package com.lga.algorithm.tag.medium._560;

/**
 * 560. 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class SubarraySum {


        public int subarraySum(int[] nums, int k) {
            int len = nums.length;
            int count = 0;
            for (int left = 0; left < len; left++) {
                for (int right = left; right < len; right++) {

                    int sum = 0;
                    String str = "";
                    for (int i = left; i <= right; i++) {
                        sum += nums[i];
                        str +=nums[i] +",";
                    }
                    System.out.println(str);
                    if (sum == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int k = 2;
        SubarraySum solution = new SubarraySum();
        int res = solution.subarraySum(nums, k);
        //System.out.println(res);
    }
}
