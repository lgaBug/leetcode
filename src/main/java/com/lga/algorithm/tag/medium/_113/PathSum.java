package com.lga.algorithm.tag.medium._113;

import com.lga.datastruct.lru.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 */
public class PathSum {



    private List<List<Integer>> ans = new LinkedList<>();

    /**
     * 暴力法遍历
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return ans;
        dfs(root,sum,0,new LinkedList<Integer>());
        return ans;
    }

    private void dfs(TreeNode root, int sum, int cur,LinkedList curList){
        if(root == null) return;
        curList.add(root.val);
        int temp = cur + root.val;
        if(temp == sum && root.left == null && root.right == null){
            ans.add(curList);
            return;
        }
        dfs(root.left,sum,temp,new LinkedList<Integer>(curList));
        dfs(root.right,sum,temp,new LinkedList<Integer>(curList));
    }

    /**
     * 回溯法
     *
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum_1(TreeNode root, int sum) {
        if (root == null) return ans;
        backtrace(root, sum, new LinkedList<Integer>());
        return ans;
    }

    private void backtrace(TreeNode root, int sum, LinkedList<Integer> trace) {

        if (root == null) return;
        trace.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            ans.add(new LinkedList<>(trace));
        }
        backtrace(root.left, sum - root.val, trace);
        backtrace(root.right, sum - root.val, trace);
        trace.removeLast();
    }

}
