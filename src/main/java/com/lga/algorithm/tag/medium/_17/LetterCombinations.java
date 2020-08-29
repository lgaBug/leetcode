package com.lga.algorithm.tag.medium._17;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {

    List<String> ans = new ArrayList<>();
    String[] letter_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return ans;
        }
        iterStr(digits, "", 0);

        return ans;
    }

    private void iterStr(String digits, String curStr, int curCount) {
        //终止条件
        if (digits.length() == curCount) {
            ans.add(curStr);
            return;
        }
        char c = digits.charAt(curCount);
        int pos = c - '0' -2;

        //获取当前层的3个字母
        String letter_str = letter_map[pos];

        for (int i = 0; i < letter_str.length(); i++) {
            iterStr(digits, curStr + letter_str.charAt(i), curCount + 1);
        }

    }
}
