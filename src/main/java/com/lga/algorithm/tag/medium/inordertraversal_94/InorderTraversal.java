package com.lga.algorithm.tag.medium.inordertraversal_94;

import com.lga.datastruct.lru.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {
    List ans = new LinkedList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            ans.add(root.val);
            inorderTraversal(root.right);
        }
        return ans;
    }
}
