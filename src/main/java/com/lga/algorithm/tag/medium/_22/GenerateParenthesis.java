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

    /**
     * 生成括号的所有可能
     * @param n 括号对数
     * @return
     */
    public void generateParenthesis_1(int n) {

        generate_1(0, 2*n, "");

    }

    private void generate_1(int i, int n, String s) {

        if (i >= n) {
            System.out.println(s);
            return;
        }
        generate_1(i+1,n, s + "(");
        generate_1(i+1,n, s + ")");


    }

    @Test
    public void test_generateParenthesis() {

        List<String> strings = generateParenthesis(3);
        System.out.println("strings = " + strings);
    }


    @Test
    public void test_generateParenthesis_1() {
        generateParenthesis_1(2);
    }

}
