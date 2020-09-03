package com.lga.algorithm.tag.medium._55;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {
    /**
     * 记录跳到最远距离
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxIndex = 0;
        for (int i = 0; i < len; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }
        return true;
    }

    /**
     * 倒推
     * @param nums
     * @return
     */
    public boolean canJump_1(int[] nums) {
        int len = nums.length;
        int endReachable = len-1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] +i >= endReachable){
                endReachable = i;
            }
        }
        return endReachable == 0;
    }

}
