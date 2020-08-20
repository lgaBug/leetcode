package com.lga.algorithm.tag.eazy._242;

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
     * 使用hashMap
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap();
        for (Character c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        for (Character c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) return false;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 哈希法的增强版
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertFalse(isAnagram_1("a", "b"));
        Assert.assertTrue(isAnagram_1("anagram", "nagaram"));
        Assert.assertFalse(isAnagram("rat", "car"));
        Assert.assertFalse(isAnagram("aacc", "ccac"));

    }
}
