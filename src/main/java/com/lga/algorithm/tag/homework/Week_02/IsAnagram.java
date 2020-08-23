package com.lga.algorithm.tag.homework.Week_02;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/description/
 */
public class IsAnagram {

    /**
     * hash 统计法
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_hash(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.get(c) != null ? map.get(c) + 1 : 1);
        }

        for (Character c : t.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) < 0 ) return false;
            }else{
                return false;
            };
        }

        return true;
    }

    /**
     * 数组模拟哈希法
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_array(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        for (Character c : s.toCharArray()) {
            arr[c-'a']++;
        }

        for (Character c : t.toCharArray()) {
            arr[c-'a']--;
            if (arr[c-'a'] < 0) return false;
        }
        return true;
    }

    @Test
    public void test_isAnagram() {

        Assert.assertFalse(isAnagram_hash("ab","a"));
        Assert.assertTrue(isAnagram_hash("anagram","nagaram"));
        Assert.assertTrue(isAnagram_array("anagram","nagaram"));

    }

}
