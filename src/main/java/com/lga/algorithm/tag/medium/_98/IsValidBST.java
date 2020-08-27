package com.lga.algorithm.tag.medium._98;

import com.lga.datastruct.lru.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {

    Long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        //return isBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
        return isIncreamentByInOrder(root);
    }

    /**
     * 符合搜索二叉树的特征，则中序遍历是递增的
     * @param root
     * @return
     */
    private boolean isIncreamentByInOrder(TreeNode root) {
        if (root == null) return true;

        if (!isIncreamentByInOrder(root.left)) return false;
        if (root.val < pre) return false;
        pre =Long.valueOf(root.val);
        if (!isIncreamentByInOrder(root.right)) return false;
        return true;

    }

    /**
     * 根据左子树小于根节点，右子树大于根节点的特征来遍历树
     *
     * @param root
     * @param maxValue
     * @param minValue
     * @return
     */
    private boolean isBST(TreeNode root, long maxValue, long minValue) {
        if (root == null) return true;
        if (root.val >= maxValue || root.val <= minValue) return false;
        return isBST(root.left, root.val, minValue) && isBST(root.right, maxValue, root.val);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(6);
        TreeNode root3 = null;
        TreeNode root4 = null;
        TreeNode root5 = new TreeNode(3);
        TreeNode root6 = new TreeNode(7);

        root.left = root1;
        root.right = root2;

        root2.left = root5;
        root2.right = root6;

        boolean validBST = isValidBST(root);
        Assert.assertFalse(validBST);

    }
}
