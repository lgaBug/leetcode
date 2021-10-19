package com.lga.windows;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WindowsProblem {

    /**
     * 76. 最小覆盖子串
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap();
        Map<Character, Integer> windows = new HashMap();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right++);
            // 把元素添加到窗口
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }

            //判断是否需要收缩
            while (valid == need.size()) {
                //更新最小字串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char b = s.charAt(left++);
                if (need.containsKey(b)) {
                    if (need.get(b).equals(windows.get(b))) {
                        valid--;
                    }
                    windows.put(b, windows.get(b) - 1);

                }
            }

        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, len + start);
    }

    /**
     * 567. 字符串的排列
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> need = new HashMap();
        Map<Character, Integer> window = new HashMap();

        //将t中的字符放到need中
        for (char c : s1.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {
            Character c = s2.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) valid++;
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) return true;

                Character b = s2.charAt(left);
                left++;
                if (need.containsKey(b)) {
                    if (need.get(b).equals(window.get(b))) valid--;
                    window.put(b, window.get(b) - 1);
                }
            }

        }

        return false;
    }

    /**
     * 438. 找到字符串中所有字母异位词
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> need = new HashMap();
        Map<Character, Integer> windows = new HashMap();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        List<Integer> res = new LinkedList();

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {

            //指针右移
            char c = s.charAt(right++);

            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(windows.get(c))) valid++;
            }

            //窗口缩小
            while (right - left >= p.length()) {

                if (valid == need.size()) {
                    res.add(left);
                }

                char d = s.charAt(left++);

                if (need.containsKey(d)) {
                    if (need.get(d).equals(windows.get(d))) valid--;
                    windows.put(d, windows.get(d) - 1);
                }
            }

        }

        return res;
    }

    /**
     * 3. 无重复字符的最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> windows = new HashMap();

        int left = 0;
        int right = 0;
        int res = 0;

        while(right < s.length()) {

            char c = s.charAt(right++);
            windows.put(c,windows.getOrDefault(c,0) + 1);

            while(windows.get(c) > 1) {
                char d = s.charAt(left++);
                windows.put(d,windows.getOrDefault(d,0) - 1);
            }

            res = Math.max(res,right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        WindowsProblem windowsProblem = new WindowsProblem();
        String s = windowsProblem.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("s = " + s);
    }
}
