package com.lga.algorithm.tag.homework.Week_02;

import com.lga.datastruct.lru.TreeNode;

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


}
