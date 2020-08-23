package com.lga.algorithm.tag.homework.Week_02;

import com.lga.datastruct.lru.Node;

import java.security.cert.PolicyQualifierInfo;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 429. N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class LevelOrder {

    /**
     * queue 实现层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<Node> queue = new LinkedList();

        if (root == null) return ans;
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> tempList = new LinkedList<>();
            int queueLength = queue.size();
            while (queueLength > 0) {
                Node tempNode = queue.poll();
                tempList.add(tempNode.val);
                queue.addAll(tempNode.children);
                queueLength--;
            }
            ans.add(tempList);
        }
        return ans;
    }
}
