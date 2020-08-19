package com.lga.algorithm.tag.eazy._59;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 1) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList();

        for (int i = 0, j = 1 - k; i < nums.length; i++,j++) {
            if (j > 0 && queue.peekFirst() == nums[j - 1]) queue.pollFirst();
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) queue.pollLast();
            queue.addLast(nums[i]);
            if (j >= 0) {
                ans[j] = queue.peekFirst();
            }

        }
        return ans;
    }

    @Test
    public void test() {

        Assert.assertTrue(Arrays.equals(new int[]{7, 7, 7, 7, 7}, maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4)));

        Assert.assertTrue(Arrays.equals(new int[]{7, 4}, maxSlidingWindow(new int[]{7, 2, 4}, 2)));

        Assert.assertTrue(Arrays.equals(new int[]{3, 3, 5, 5, 6, 7}, maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));

    }

}
