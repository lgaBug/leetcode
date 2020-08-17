package com.lga.algorithm.tag.eazy.preorder_589;

import com.lga.datastruct.lru.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class Preorder {

    private List<Integer> ans = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        if (root != null) {
            ans.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return ans;
    }
}
