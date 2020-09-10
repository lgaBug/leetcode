package com.lga.algorithm.tag.eazy._101;

import com.lga.datastruct.lru.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class IsSymmetric {

    /**
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        Deque<String> deque = new LinkedList<>();
        inorder(deque, root);
        while (!deque.isEmpty() && deque.size() != 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) return false;
        }
        return true;
    }

    //中序遍历会
    private void inorder(Deque<String> deque, TreeNode root) {
        if (root == null)  return;
        inorder(deque, root.left);
        deque.addLast(root.val + "");
        inorder(deque, root.right);
    }

    /**
     *
     * @param root
     * @return
     */
    public boolean isSymmetric_1(TreeNode root) {
        if (root == null) return true;
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        boolean symmetric = isSymmetric(treeNode);

        System.out.println("symmetric = " + symmetric);

    }
}
