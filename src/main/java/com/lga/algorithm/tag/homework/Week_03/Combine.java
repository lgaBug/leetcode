package com.lga.algorithm.tag.homework.Week_03;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine {

    private List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> trace = new LinkedList<>();
        backtrace(0, n, k, trace);
        return ans;
    }

    private void backtrace(int i, int n, int k, LinkedList<Integer> trace) {
        //终止条件
        if (trace.size() == k) {
            ans.add(new LinkedList<>(trace));
            return;
        }

        while (i++ < n) {
            trace.add(i);
            //进入下一层
            backtrace(i, n, k, trace);
            //返回上一层
            trace.removeLast();
        }
    }
}
