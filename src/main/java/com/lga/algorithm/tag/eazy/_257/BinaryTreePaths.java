package com.lga.algorithm.tag.eazy._257;

import com.lga.datastruct.lru.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    private List<String> ans = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ans;
        dfs(root, "");
        return ans;
    }

    private void dfs(TreeNode root, String s) {
        if (root == null) return;
        String temp = s + "->" + root.val;
        if (root.left == null && root.right == null) {
            ans.add(temp.substring(2));
            return;
        }
        dfs(root.left, temp);
        dfs(root.right,temp);
    }
}
