package com.lga.algorithm.tag.eazy._590;

import com.lga.datastruct.lru.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class Postorder {

    private List<Integer> ans = new LinkedList<>();
    public List<Integer> postorder(Node root) {
        if (root != null) {
            for (Node node : root.children) {
                postorder(node);
            }
            ans.add(root.val);
        }
        return ans;
    }
}
