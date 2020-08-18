package com.lga.algorithm.tag.eazy.removeouterparentheses_1021;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 1021. 删除最外层的括号
 * https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
public class RemoveOuterParentheses {

    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack();
        int start = 0;
        int end = 0;
        String ans = "";
        for (int i = 0; i < S.length(); i++) {

            if (!stack.isEmpty()) {
                if (S.charAt(i) == ')') {
                    stack.pop();
                    if (stack.isEmpty()){
                        end = i;
                        ans += S.substring(start + 1, end);
                    }
                } else {
                    stack.push(S.charAt(i));
                }
            } else {
                stack.push(S.charAt(i));
                start = i;
            }
        }
        return ans;
    }

    public String removeOuterParentheses1(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Character c : S.toCharArray()) {
            if(c ==')') count--;
            if (count>=1) sb.append(c);
            if(c == '(') count++;
        }
        return sb.toString();
    }

    /**
     * 上面的进阶版本
     * @param S
     * @return
     */
    public String removeOuterParentheses2(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Character c : S.toCharArray()) {
            if(c =='(' && count++ >0) sb.append(c);
            if(c == ')' && count-->1) sb.append(c);
        }
        return sb.toString();
    }


    @Test
    public void test() {
        Assert.assertEquals("()()()", removeOuterParentheses2("(()())(())"));

        Assert.assertEquals("()()()()(())", removeOuterParentheses2("(()())(())(()(()))"));


    }
}
