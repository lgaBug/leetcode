package com.lga.algorithm.tag.medium._18;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        //排序nums
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                int l = j + 1;
                int r = nums.length - 1;
                //去重
                if (j >i+1 && nums[j] == nums[j - 1]) continue;

                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(fourSum(new int[]{0, 0, -0, 0}, 0));

        //System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

}
