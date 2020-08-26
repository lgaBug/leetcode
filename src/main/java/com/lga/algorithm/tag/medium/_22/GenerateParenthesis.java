package com.lga.algorithm.tag.medium._22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    private List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        generate(0, 0, n, "");
        return ans;
    }

    private void generate(int left, int right, int n, String s) {

        if (left == n && right == n) {
            ans.add(s);
            return;
        }

        if (left < n)
            generate(left + 1, right, n, s + "(");
        if (left > right)
            generate(left, right + 1, n, s + ")");
    }

    @Test
    public void test_generateParenthesis() {

        List<String> strings = generateParenthesis(3);
        System.out.println("strings = " + strings);
    }

}
