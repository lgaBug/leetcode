package com.lga.algorithm.tag.medium._102;

import com.lga.datastruct.lru.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历BFS
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 */
public class LevelOrder {

    /**
     * 队列实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_deque(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        Deque<TreeNode> deque = new LinkedList();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> tempList = new LinkedList<>();
            while (size-- > 0) {
                TreeNode peek = deque.peek();
                tempList.add(deque.pop().val);
                if (peek.left != null) {
                    deque.add(peek.left);
                }
                if (peek.right != null) {
                    deque.add(peek.right);
                }
            }
            ans.add(tempList);

        }
        return ans;
    }

    /**
     * 深度遍历，前序
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_dfs(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root != null) dfs(0, root, ans);
        return ans;
    }

    private void dfs(int level, TreeNode root, List<List<Integer>> ans) {

        if (ans.size() - 1 < level) {
            ans.add(new LinkedList<Integer>());
        }
        ans.get(level).add(root.val);
        if (root.left != null) dfs(level + 1, root.left, ans);
        if (root.right != null) dfs(level + 1, root.right, ans);

    }
}
