package com.lga.algorithm.tag.eazy._112;

import com.lga.datastruct.lru.TreeNode;

import java.util.LinkedList;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 */
public class HasPathSum {
    boolean ans = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        backtrace(root, sum);
        return ans;
    }

    private void backtrace(TreeNode node, int target) {
        if(ans) return;
        if (node == null) return;
        if (node.left == null && node.right == null && target == node.val) {
            ans = true;
            return;
        }
        backtrace(node.left, target - node.val);
        backtrace(node.right, target - node.val);
    }
}
