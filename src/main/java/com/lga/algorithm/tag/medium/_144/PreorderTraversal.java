package com.lga.algorithm.tag.medium._144;

import com.lga.datastruct.lru.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class PreorderTraversal {

    List ans = new LinkedList();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            ans.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return ans;
    }
}
