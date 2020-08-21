package com.lga.datastruct.lru;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * deep first search
 * 深度优先遍历
 */
public class DFS {

    /**
     * 使用stack
     * 二叉树中序遍历
     *  @param root
     */
    public void binaryTree_dfs(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + "->");
            root = root.right;
        }
    }

    /**
     * 图的深度遍历
     *
     * @param graphMap
     * @param startVertx 开始顶点
     */
    public void graph_dfs(Map<String, String[]> graphMap, String startVertx) {

    }




    @Test
    public void test() {
        TreeNode treeNode0 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(8);
        TreeNode treeNode8 = new TreeNode(9);

        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        treeNode3.left = treeNode7;
        treeNode3.right = treeNode8;

        binaryTree_dfs(treeNode0);
    }

}
