package com.lga.algorithm.tag.homework.Week_02;

import com.lga.datastruct.lru.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class PreorderTraversal {

    List<Integer> ans = new LinkedList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_recursion(TreeNode root) {
        if (root != null) {
            ans.add(root.val);
            preorderTraversal_recursion(root.left);
            preorderTraversal_recursion(root.right);
        }
        return ans;
    }

    /**
     * 使用stack 深度遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_stack(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return ans;
    }

}
