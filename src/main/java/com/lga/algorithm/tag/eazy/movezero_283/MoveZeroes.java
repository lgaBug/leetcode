package com.lga.algorithm.tag.eazy.movezero_283;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 283. 移动零
 * <p>
 * subject description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * https://leetcode-cn.com/problems/move-zeroes/
 * <p>
 * case 1:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * topic
 * 1、必须在原数组上操作，不能拷贝额外的数组。
 * 2、尽量减少操作次数。
 */
public class MoveZeroes {


    public void moveZeroes(int[] nums) {

        //用于记录非零数的位置
        int j =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (j != i) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (;j < nums.length; j++) {
            nums[j] = 0;
        }
    }


    public void moveZeroes1(int[] nums) {
        int count = 0;
        int i = 0;
        while (i < nums.length - count) {
            if (nums[i] == 0) {
                int j = i;
                while (j < nums.length - 1) {
                    nums[j] = nums[j + 1];
                    j++;
                }
                count++;
                nums[nums.length - 1] = 0;
                i =0;
                continue;
            }
            i++;
        }

    }

    public void moveZeroes3(int[] nums) {
        //用于记录非零元素
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
                if (j != i) {
                    nums[i] = 0;
                }
            }
        }
    }


    @Test
    public void test1() {
        int[] nums = {0, 1, 0, 3, 12};
            moveZeroes3(nums);
        Assert.assertTrue(Arrays.equals(nums, new int[]{1, 3, 12, 0, 0}));

    }

    @Test
    public void test2() {
        int[] nums = {0, 0, 1};
        moveZeroes3(nums);
        Assert.assertTrue(Arrays.equals(nums, new int[]{1, 0, 0}));

    }
}
