package com.lga.algorithm.tag.medium._77;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Combine {

    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {

        if (k == 0) return null;

        backtrace(0, n, k, new LinkedList<Integer>());
        return ans;
    }

    private void backtrace(int i, int n, int k, LinkedList<Integer> trace) {

        //终止条件
        if (trace.size() == k) {
            ans.add(new LinkedList<>(trace));
            return;
        }
        while (i < n) {
            trace.add(i + 1);
            backtrace(++i,n,k,trace);
            trace.removeLast();
        }
    }
}
