package com.lga.algorithm.tag.homework.Week_02;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 1. 两数之和
 *
 * https://leetcode-cn.com/problems/two-sum/description/
 */
public class TwoSum {

    /**
     * 哈希法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_hash(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int otherNum = target - nums[i];
            if (map.containsKey(otherNum)) return new int[]{map.get(otherNum), i};
            map.put(nums[i], i);
        }

        return new int[0];

    }



    @Test
    public void test_sum() {

        Assert.assertTrue(Arrays.equals(new int[]{0,1}, twoSum_hash(new int[]{2, 7, 11, 15}, 9)));
    }
}
