package com.lga.algorithm.tag.homework.Week_03;

import com.lga.datastruct.lru.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {//左子树为空
            return right;
        } else if (right == null) {//右子树为空
            return left;
        } else {//左右子树都不为空
            return root;
        }
    }

}
