package com.lga.algorithm.tag.eazy._104;

import com.lga.datastruct.lru.TreeNode;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;

        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;

        return Math.max(left, right);


    }
}
