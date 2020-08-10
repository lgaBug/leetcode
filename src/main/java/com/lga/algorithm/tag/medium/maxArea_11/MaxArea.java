package com.lga.algorithm.tag.medium.maxArea_11;

import org.junit.Assert;
import org.junit.Test;

/**
 * 11. 盛最多水的容器
 链接：https://leetcode-cn.com/problems/container-with-most-water
 *
 */
public class MaxArea {

    /**
     * 暴力破解法
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j])*(j-i));
            }
        }
        return max;
    }

    /**
     * 双指针法
     * 时间复杂度O(1)
     * 空间复杂度O(1)
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(max, (right-left)*height[left++]);
            }else{
                max = Math.max(max, (right-left)*height[right--]);
            }
        }
        return max;
    }

    @Test
    public void test1() {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assert.assertEquals(49,maxArea1(heights));
    }
}
