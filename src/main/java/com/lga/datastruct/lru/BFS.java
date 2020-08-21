package com.lga.datastruct.lru;

import org.junit.Test;
import sun.reflect.ReflectionFactory;

import java.util.*;

/**
 * breath first search
 * 广度优先遍历
 */
public class BFS {

    /**
     * 二叉树的层次遍历
     * @param root
     */
    public void binaryTreeBfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode removeNode = queue.poll();
            System.out.print(removeNode.val + " -> ");
            if (removeNode.left != null) queue.add(removeNode.left);
            if (removeNode.right != null) queue.add(removeNode.right);
        }

    }

    /**
     * 图的层次遍历
     * @param graphMap
     * @param startVertx 从startVertx顶点开始层次遍历
     */
    public void graphBfs(Map<String, String[]> graphMap,String startVertx) {

        if (!graphMap.containsKey(startVertx)) throw new IllegalArgumentException("该顶点不存在");

        //记录已经访问过的节点
        Set<String> accessed = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startVertx);
        accessed.add(startVertx);

        while (!queue.isEmpty()) {
            String removeVertx = queue.poll();
            System.out.print(removeVertx + "->");
            if (graphMap.containsKey(removeVertx)) {
                String[] vertxs = graphMap.get(removeVertx);
                for (String vertx : vertxs) {
                    if (!accessed.contains(vertx)) {
                        queue.add(vertx);
                        accessed.add(vertx);
                    }
                }
            }
        }
    }

    @Test
    public void test_binaryTreeBfs() {

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

        binaryTreeBfs(treeNode0);

    }


    @Test
    public void test_graphBfs() {

        Map<String, String[]> grapMap = new HashMap<String, String[]>(){{

            put("A",new String[]{"B","C"});
            put("B",new String[]{"D","E"});
            put("C",new String[]{"E","F","A"});
            put("D",new String[]{"B"});
            put("E",new String[]{"B","G","C"});
            put("F",new String[]{"C"});
            put("G",new String[]{"E"});
        }};

        graphBfs(grapMap, "C");
    }


}
