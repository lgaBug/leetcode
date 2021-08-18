package com.lga.algorithm.tag.tree._654;

import com.lga.datastruct.lru.TreeNode;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {


    /**
     * 654. 最大二叉树
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums == null || nums.length == 0) return null;

        int maxVal = Integer.MIN_VALUE;
        int maxValIndex = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] > maxVal){
                maxVal = nums[i];
                maxValIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);

        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,maxValIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxValIndex+1,nums.length));
        return root;
    }


    public static void main(String[] args) {

        final ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        constructMaximumBinaryTree.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
