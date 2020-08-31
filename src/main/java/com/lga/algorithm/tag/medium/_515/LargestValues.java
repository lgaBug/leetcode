package com.lga.algorithm.tag.medium._515;

import com.lga.datastruct.lru.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
 */
public class LargestValues {

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();

            int max = Integer.MIN_VALUE;
            while (size-->0) {
                TreeNode pop = deque.pop();
                if (pop.val > max) max = pop.val;
                if (pop.left != null) deque.add(pop.left);
                if (pop.right != null) deque.add(pop.right);

            }
            ans.add(max);
        }
        return ans;
    }


    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(-2147483648);
        treeNode.right = new TreeNode(2147483647);
        largestValues(treeNode);
    }

}
