package com.lga.algorithm.tag.eazy._617;

import com.lga.datastruct.lru.TreeNode;

/**
 * 617. 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class MergeTrees {


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 ==null) return t2;
        if(t2 == null) return t1;
        t1.val+=t2.val;
        t1.left =  mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
