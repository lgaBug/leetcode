package com.lga.algorithm.tag.medium._429;

import com.lga.datastruct.lru.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class LevelOrder {


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> tempList = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node pollNode = queue.poll();
                    tempList.add(pollNode.val);
                    queue.addAll(pollNode.children);
                }
                ans.add(tempList);
            }
        }
        return ans;
    }
}
