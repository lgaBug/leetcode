package com.lga.algorithm.tag.medium._78;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) return null;

        backtrace(0, nums, new LinkedList<Integer>());

        return ans;
    }

    private void backtrace(int i, int[] nums, LinkedList<Integer> trace) {
        ans.add(new LinkedList<>(trace));
        while (i < nums.length) {
            trace.add(nums[i]);
            backtrace(++i, nums, trace);
            trace.removeLast();
        }
    }

    @Test
    public void test() {
        subsets(new int[]{1, 2, 3});
    }
}
