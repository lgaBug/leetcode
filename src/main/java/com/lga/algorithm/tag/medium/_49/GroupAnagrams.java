package com.lga.algorithm.tag.medium._49;

import sun.security.action.PutAllAction;

import java.util.*;

/**
 * 49. 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (final String s : strs) {

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            }else{
                map.put(key, new LinkedList<String>() {{
                    add(s);
                }});
            }

        }
        return new ArrayList<List<String>>(map.values());
    }


}
