package com.lga.algorithm.tag.tree._652;

import com.lga.datastruct.lru.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {




    List<TreeNode> result = new ArrayList();
    Map<String,Integer> subTreeMap = new HashMap();


    /**
     * 652. 寻找重复的子树
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }

    private String traverse(TreeNode root){


        if(root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;

        int freq = subTreeMap.getOrDefault(subTree,0);

        if(freq == 1){
            result.add(root);
        }

        subTreeMap.put(subTree,freq + 1);

        return subTree;
    }

}
