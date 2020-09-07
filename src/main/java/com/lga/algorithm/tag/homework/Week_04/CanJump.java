package com.lga.algorithm.tag.homework.Week_04;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length ==1) return true;
        if (nums[0] == 0) return false;
        int maxIndex = 0;
        for (int i = 0;i<nums.length;i++) {
            if(i > maxIndex) return false;
            maxIndex = Math.max(maxIndex, nums[i] + i);
        }
        return true;
    }
}
