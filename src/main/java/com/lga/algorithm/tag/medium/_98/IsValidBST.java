package com.lga.algorithm.tag.medium._98;

import com.lga.datastruct.lru.TreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {


    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

    private boolean helper(TreeNode root, Integer lower, Integer upper) {

        if (root == null) return true;

        int curVal = root.val;

        //左子树大于根节点则返回false
        if (curVal < lower) return false;
        //右子树小于当前根节点则返回false
        if (curVal > upper) return false;

        //遍历左子树
        if (!helper(root.left, lower, curVal)) return false;

        //遍历右子树
        if (!helper(root.right, curVal, upper)) return false;

        return true;

    }
}
