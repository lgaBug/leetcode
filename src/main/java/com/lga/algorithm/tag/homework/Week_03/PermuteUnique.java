package com.lga.algorithm.tag.homework.Week_03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermuteUnique {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        ArrayList<Integer> trace = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums,new boolean[nums.length], trace);
        return ans;
    }

    private void backtrace(int[] nums, boolean[] visited, ArrayList<Integer> trace) {
        //终止条件
        if (trace.size() == nums.length) {
            ans.add(new ArrayList<>(trace));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(visited[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && visited[i-1]) break;
            //做出选择
            trace.add(nums[i]);
            visited[i] = true;
            backtrace(nums, visited, trace);
            //撤销选择
            trace.remove(trace.size()-1);
            visited[i] = false;
        }
    }

    private boolean hasSubElement(List<List<Integer>> ans, ArrayList<Integer> trace) {
        for (List<Integer> sub : ans) {
            if (Arrays.equals(sub.toArray(),trace.toArray())) return true;
        }
        return false;
    }

}
