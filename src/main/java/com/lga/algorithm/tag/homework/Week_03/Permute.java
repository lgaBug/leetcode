package com.lga.algorithm.tag.homework.Week_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        ArrayList<Integer> trace = new ArrayList<>();
        backtrace(nums, trace);
        return ans;
    }

    private void backtrace(int[] nums, ArrayList<Integer> trace) {
        //终止条件
        if (trace.size() == nums.length) {
            ans.add(new ArrayList<>(trace));
            return;
        }

        for (int num : nums) {
            if (trace.contains(num)) continue;
            trace.add(num);
            backtrace(nums, trace);
            trace.remove(trace.size()-1);
        }
    }

}
