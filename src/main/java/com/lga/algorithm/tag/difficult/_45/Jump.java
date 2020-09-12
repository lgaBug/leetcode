package com.lga.algorithm.tag.difficult._45;

import org.junit.Test;

/**
 * 45. 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Jump {

    public int jump(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    private int step = 0;
    public int jump_rec(int[] nums) {
        int endIndex = nums.length - 1;
        find(nums, endIndex);
        return step;
    }

    private void find(int[] nums, int endIndex) {

        if (endIndex ==0) return;
        for (int i = 0; i <= endIndex; i++) {
            if (nums[i] + i >= endIndex) {
                step++;
                find(nums,i);
                break;
            }
        }
    }


    @Test
    public void test() {

        int ans = jump_rec(new int[]{2, 3, 1, 1, 4});
        System.out.println("ans = " + ans);

    }

}
