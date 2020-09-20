package com.lga.algorithm.tag.homework.Week_05;

import org.junit.Test;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class CountSubstrings {

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() < 1) return 0;
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < chars.length; j++) {
                if (isRecStr(sb.append(String.valueOf(chars[j])).toString())) ans++;
            }
        }
        return ans;
    }

    private boolean isRecStr(String str) {
        int end = str.length() - 1;
        int start = 0;
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    /**
     * dp法
     * @param s
     * @return
     */
    public int countSubstrings_dp(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }

            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(countSubstrings("aba"));

    }
}
