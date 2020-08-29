package com.lga.algorithm.tag.medium._78;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new LinkedList<>();
        backtrack(0, nums, ans, new LinkedList<>());
        return ans;
    }

    private void backtrack(int j, int[] nums, List<List<Integer>> ans, LinkedList<Integer> temp) {
        ans.add(new LinkedList<>(temp));
        for (; j < nums.length; j++) {
            temp.add(nums[j]);
            backtrack(j + 1, nums, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test() {
        subsets(new int[]{1,2,3});
    }
}
