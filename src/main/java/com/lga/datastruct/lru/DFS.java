package com.lga.datastruct.lru;

import org.junit.Test;

import java.util.*;

/**
 * deep first search
 * 深度优先遍历
 */
public class DFS {

    /**
     * 使用stack
     * 二叉树中序遍历
     *  @param root
     */
    public void binaryTree_dfs(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + "->");
            root = root.right;
        }
    }

    /**
     * 图的深度遍历
     *
     * @param graphMap
     * @param startVertx 开始顶点
     */
    public void graph_dfs(Map<String, String[]> graphMap, String startVertx) {

        if (!graphMap.containsKey(startVertx)) throw new IllegalArgumentException("该顶点不存在");

        //记录已经访问过的节点
        Set<String> accessed = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.add(startVertx);
        accessed.add(startVertx);

        while (!stack.isEmpty()) {
            String removeVertx = stack.pop();
            System.out.print(removeVertx + "->");
            if (graphMap.containsKey(removeVertx)) {
                String[] vertxs = graphMap.get(removeVertx);
                for (String vertx : vertxs) {
                    if (!accessed.contains(vertx)) {
                        stack.add(vertx);
                        accessed.add(vertx);
                    }
                }
            }
        }

    }




    @Test
    public void test_binaryTree_dfs() {
        TreeNode treeNode0 = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(8);
        TreeNode treeNode8 = new TreeNode(9);

        treeNode0.left = treeNode1;
        treeNode0.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        treeNode3.left = treeNode7;
        treeNode3.right = treeNode8;

        binaryTree_dfs(treeNode0);
    }

    @Test
    public void test_graph_dfs() {

        Map<String, String[]> grapMap = new HashMap<String, String[]>(){{

            put("A",new String[]{"B","C"});
            put("B",new String[]{"D","E"});
            put("C",new String[]{"E","F","A"});
            put("D",new String[]{"B"});
            put("E",new String[]{"B","G","C"});
            put("F",new String[]{"C"});
            put("G",new String[]{"E"});
        }};

        graph_dfs(grapMap, "C");

    }
}
