package com.lga.algorithm.tag.eazy.isvalid_20;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * <p>
 * subject description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class IsValid {

    /**
     * 哈希法
     *
     * @param s
     * @return
     */
    public boolean isValid_hash(String s) {
        if (s == null || s.length() % 2 == 1) return false;
        Map<Character, Character> map = new HashMap() {
            {
                put('(', ')');
                put('{', '}');
                put('[', ']');
            }
        };
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && map.get(stack.pop()) != s.charAt(i)) return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i) || '{' == s.charAt(i) || '[' == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (isMatch(s.charAt(i), stack))
                        return false;
                    stack.pop();
                }

            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(Character s, Stack<Character> stack) {
        return (stack.peek() == '[' && s != ']') || (stack.peek() == '(' && s != ')') || (stack.peek() == '{' && s != '}');
    }

    @Test
    public void test1() {
        Assert.assertTrue(isValid("()"));
        Assert.assertTrue(isValid("()[]{}"));
        Assert.assertFalse(isValid("(]"));
        Assert.assertFalse(isValid("([)]"));
        Assert.assertTrue(isValid("{[]}"));
        Assert.assertFalse(isValid("{"));
        Assert.assertFalse(isValid("}"));
    }
}
