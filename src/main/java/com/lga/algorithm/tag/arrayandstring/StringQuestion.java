package com.lga.algorithm.tag.arrayandstring;

public class StringQuestion {


    /**
     * 最长公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        int length = strs.length;

        if (strs == null || length == 0) {
            return "";
        }
        String tempStr = strs[0];
        if (length == 1) {
            return tempStr;
        }
        while (tempStr.length() > 0) {

            for (int i = 1; i < length; i++) {
                if (strs[i].startsWith(tempStr)) {
                    if (i == length - 1) {
                        return tempStr;
                    }
                } else {
                    tempStr = tempStr.substring(0, tempStr.length() - 1);
                    break;
                }
            }
        }
        return tempStr;
    }


    /**
     * 最长回文子串
     * 暴力解法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        String longestPalind = "";
        int maxLength = 0;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isPalindromic(s.substring(i, j)) && s.substring(i, j).length() > maxLength) {
                    longestPalind = s.substring(i, j);
                    maxLength = longestPalind.length();
                }
            }
        }
        return longestPalind;
    }

    private boolean isPalindromic(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最长回文子串
     * 中心扩散法
     * * @param s
     *
     * @return
     */
    public String longestPalindrome01(String s) {

        if (s.length() == 1) {
            return s;
        }

        int maxLength = 0;
        int maxLeft = 0;
        int maxRight = 0;


        for (int i = 0; i < s.length() - 1; i++) {
            int len = 1;
            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }

            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }

            while (right < s.length() && left >= 0 && s.charAt(right) == s.charAt(left)) {
                len += 2;
                left--;
                right++;
            }

            if (len > maxLength) {
                maxLength = len;
                maxLeft = left;
                maxRight = right;
            }
        }

        return s.substring(maxLeft + 1, maxRight);

    }
}
