package com.lga.algorithm.tag.medium._105;

import com.lga.datastruct.lru.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) throws IllegalAccessException {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) return null;

        TreeNode rootNode = new TreeNode(preorder[preLeft]);
        int pIndex = map.get(preorder[preLeft]);

        rootNode.left = buildTree(preorder, preLeft + 1, pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
        rootNode.right = buildTree(preorder, pIndex - inLeft + preLeft + 1, preRight, map, pIndex + 1, inRight);
        return rootNode;
    }
}
