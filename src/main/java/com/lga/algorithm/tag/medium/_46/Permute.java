package com.lga.algorithm.tag.medium._46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<Integer>());

        return ans;
    }

    /**
     *
     * @param nums
     * @param track 记录已经走过的元素
     */
    private void backtrack(int[] nums, LinkedList<Integer> track) {

        //终止条件
        if (nums.length == track.size()) {
            ans.add(track);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums,track);
            //取消选择
            track.removeLast();
        }
    }
}
