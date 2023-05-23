package com.lga.bytedance;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WindowsTEST {


    public String minWindow(String s, String t) {

        // 初始化
        int left = 0;
        int right = 0;
        int valid = 0;
        int resLen = Integer.MAX_VALUE;
        int start = 0;
        Map<Character, Integer> need = new HashMap();

        Map<Character, Integer> window = new HashMap();


        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {

            // 进入滑动窗口的元素
            Character cur = s.charAt(right);
            right++;
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (need.get(cur).equals(window.get(cur))) {
                    valid++;
                }
            }


            while (valid == need.size()) {
                //判断结果
                if (right - left < resLen) {
                    start = left;
                    resLen = right - start;
                }
                //移除滑动元素
                Character removeC = s.charAt(left);
                left++;

                if (need.containsKey(removeC)) {
                    if (need.get(removeC).equals(window.get(removeC))) {
                        valid--;
                    }
                    window.put(removeC, window.get(removeC) - 1);
                }
            }

        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(start, resLen + start);
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new LinkedList();
        int left = 0;
        int right = 0;
        int valid = 0;

        Map<Character, Integer> need = new HashMap();
        Map<Character, Integer> windows = new HashMap();

        for (Character c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {

            Character cur = s.charAt(right);
            right++;

            if (need.containsKey(cur)) {

                windows.put(cur, windows.getOrDefault(cur, 0) + 1);
                if (need.get(cur).equals(windows.get(cur))) {
                    valid++;
                }
            }

            while (valid == need.size()) {

                if (right  - left == p.length()) {
                    res.add(left);
                }

                Character removeC = s.charAt(left);
                left++;
                if (need.containsKey(removeC)) {
                    if (need.get(removeC).equals(windows.get(removeC))) {
                        valid--;
                    }
                    windows.put(removeC, windows.get(removeC) - 1);
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        WindowsTEST windowsTEST = new WindowsTEST();
//        System.out.println(windowsTEST.minWindow("ab", "a"));

        System.out.println(windowsTEST.findAnagrams("abab", "ab"));
    }
}
