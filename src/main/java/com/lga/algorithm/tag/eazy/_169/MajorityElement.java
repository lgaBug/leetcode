package com.lga.algorithm.tag.eazy._169;

import java.util.Arrays;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/description/
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
