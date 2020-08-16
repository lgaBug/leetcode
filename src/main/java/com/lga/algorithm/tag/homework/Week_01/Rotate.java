package com.lga.algorithm.tag.homework.Week_01;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 189. 旋转数组
 *
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class Rotate {

    /**
     * 暴力法
     * 时间复杂度O(kn),O(n)
     * 空间复杂度O(1)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        while (k > 0) {
            int temp = nums[nums.length-1];
            for (int i = nums.length-1; i >0 ; i--) {
                nums[i] = nums[i-1];
            }
            nums[0] = temp;
            k--;
        }
    }

    /**
     * 循环替换方法
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     * @param k
     */
    public void ratate1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; count< nums.length; i++) {
            int start = i;
            int prev = nums[start];
            do {
                int next = (start + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                start = next;
                prev = temp;
                count++;
            } while (start != i);
        }
    }

    /**
     * 反转
     * case:
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     * @param k
     */
    public void ratate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums,k,nums.length-1);
    }

    /**
     * 反转一个数组，就是前后两两互相交换值
     * @param nums
     * @param start
     * @param end
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums,1);
        Assert.assertTrue(Arrays.equals(new int[]{7,1, 2, 3, 4, 5, 6},nums));

        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums1,3);
        Assert.assertTrue(Arrays.equals(new int[]{5,6,7,1,2,3,4},nums1));
    }

    @Test
    public void test2() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ratate1(nums,1);
        Assert.assertTrue(Arrays.equals(new int[]{7,1, 2, 3, 4, 5, 6},nums));

        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        ratate1(nums1,3);
        Assert.assertTrue(Arrays.equals(new int[]{5,6,7,1,2,3,4},nums1));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        ratate2(nums,1);
        Assert.assertTrue(Arrays.equals(new int[]{7,1, 2, 3, 4, 5, 6},nums));

        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        ratate2(nums1,3);
        Assert.assertTrue(Arrays.equals(new int[]{5,6,7,1,2,3,4},nums1));
    }
}
