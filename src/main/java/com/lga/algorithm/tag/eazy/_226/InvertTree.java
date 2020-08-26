package com.lga.algorithm.tag.eazy._226;

import com.lga.datastruct.lru.ListNode;
import com.lga.datastruct.lru.TreeNode;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        //交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
}
