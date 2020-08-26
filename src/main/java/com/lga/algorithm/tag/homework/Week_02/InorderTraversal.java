package com.lga.algorithm.tag.homework.Week_02;

import com.lga.datastruct.lru.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {

    /**
     * 递归 左->根->右
     * @param root
     * @return
     */
    List<Integer> ans = new LinkedList<>();
    public List<Integer> inorderTraversal_recursion(TreeNode root) {
        if (root != null) {
            inorderTraversal_recursion(root.left);
            ans.add(root.val);
            inorderTraversal_recursion(root.right);
        }
        return ans;
    }

    /**
     * 通过stack 进行深度遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_stack(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || stack.size() > 0) {
            if (root != null) {

                stack.push(root);
                root = root.left;
            }else{
                TreeNode tempPopNode = stack.pop();
                ans.add(tempPopNode.val);
                root = tempPopNode.right;
            }
        }
        return ans;
    }


    @Test
    public void  test_inorderTraversal_recursion() {

        TreeNode root = new TreeNode(7);
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(6);
        TreeNode root5 = new TreeNode(8);
        TreeNode root6 = new TreeNode(10);

        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        root.left = root1;
        root.right = root2;


        inorderTraversal_recursion(root);
    }

}
