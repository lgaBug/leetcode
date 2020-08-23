package com.lga.algorithm.tag.homework.Week_02;

import java.util.*;

/**
 * 49. 字母异位词分组
 *https://leetcode-cn.com/problems/group-anagrams/
 *
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<String>(){{
                    add(str);
                }});
            }else {
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
