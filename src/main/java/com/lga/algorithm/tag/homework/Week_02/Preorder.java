package com.lga.algorithm.tag.homework.Week_02;

import com.lga.datastruct.lru.Node;
import com.sun.org.apache.xpath.internal.operations.And;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class Preorder {


    List<Integer> ans = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        while (root != null) {
            ans.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return ans;
    }

}
