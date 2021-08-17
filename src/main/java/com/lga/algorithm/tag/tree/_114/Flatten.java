package com.lga.algorithm.tag.tree._114;

import com.lga.datastruct.lru.TreeNode;

public class Flatten {


    public void flatten(TreeNode root) {

        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = right;

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        treeNode5.right = treeNode6;

        Flatten flatten = new Flatten();


        flatten.flatten(treeNode1);

    }
}
