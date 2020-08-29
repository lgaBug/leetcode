package com.lga.algorithm.tag.medium._15;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * subject description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * <p>
 * case 1:
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class threeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);//排序

        for(int i =0;i<nums.length-2;i++){
            if (nums[i] > 0) break;
            int l = i+1;
            int r = nums.length-1;
            if(i >0 && nums[i] == nums[i-1]) continue;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l] == nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                }else if(sum > 0){
                    r--;
                }else if (sum <0){
                    l++;
                }
            }
        }
        return ans;
    }


    @Test
    public void test() {
        System.out.println(threeSum(new int[]{0,0,0}));

        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

    }
}
