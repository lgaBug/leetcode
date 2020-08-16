package com.lga.algorithm.tag.homework.Week_01;

import org.junit.Assert;
import org.junit.Test;

/**
 * 26. 删除排序数组中的重复项
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if (nums[left] !=nums[right])
                nums[++left] = nums[right];
            right++;
        }
        return left + 1;
    }

    @Test
    public void test1() {

        Assert.assertTrue(2 == removeDuplicates(new int[]{1,1,2}));
        Assert.assertTrue(5 == removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

    }
}
