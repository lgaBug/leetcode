package com.lga.algorithm.tag.eazy.twosum_1;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * subject description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * <p>
 * case 1:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    /**
     * 一遍哈希
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int oneVal = target - nums[i];
            if (map.containsKey(oneVal)) {
                return new int[]{map.get(oneVal), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 两遍哈希
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int oneNum = target - nums[i];
            if (map.containsKey(oneNum) && map.get(oneNum) != i) {
                return new int[]{i, map.get(oneNum)};
            }
        }
        return null;
    }

    /**
     * think error
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] ans = null;
        if (nums == null || nums.length < 2) return ans;
        //排序
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 1; left++) {
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    ans = new int[2];
                    ans[0] = left;
                    ans[1] = right;
                    return ans;
                } else if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                }
            }
        }
        return ans;
    }

    /**
     * 暴力法
     * 时间复杂度O(n^2)
     */
    public int[] twoSum_force(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    @Test
    public void test1() {
        Assert.assertTrue(Arrays.equals(new int[]{0, 1}, twoSum(new int[]{2, 7, 11, 15}, 9))||Arrays.equals(new int[]{1, 0}, twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    @Test
    public void test2() {
        Assert.assertTrue(Arrays.equals(new int[]{1, 2}, twoSum(new int[]{3, 2, 4}, 6))||Arrays.equals(new int[]{2, 1}, twoSum(new int[]{3, 2, 4}, 6)));
    }

    @Test
    public void test3() {
        Assert.assertTrue(Arrays.equals(new int[]{1, 2}, twoSum(new int[]{2, 5, 5, 11}, 10))||Arrays.equals(new int[]{2, 1}, twoSum(new int[]{2, 5, 5, 11}, 10)));
    }

}
