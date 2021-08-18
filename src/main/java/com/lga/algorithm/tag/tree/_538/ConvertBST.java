package com.lga.algorithm.tag.tree._538;

import com.lga.datastruct.lru.TreeNode;

public class ConvertBST {

    private int sum = 0;


    /**
     * 538. 把二叉搜索树转换为累加树
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        reverse(root);
        return root;
    }

    private void reverse(TreeNode root){
        if(root == null) return;

        reverse(root.right);

        sum += root.val;
        root.val = sum;

        reverse(root.left);
    }
}
