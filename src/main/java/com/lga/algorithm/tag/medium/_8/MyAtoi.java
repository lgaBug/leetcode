package com.lga.algorithm.tag.medium._8;

import org.junit.Assert;
import org.junit.Test;

/**
 * subject description:
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * topic :
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 * case 1:
 * 输入: "42"
 * 输出: 42
 *
 * case 2:
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 *
 * case 3:
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * case 4:
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 *
 * case 5:
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−2^31) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class MyAtoi {

    public int myAtoi(String str) {
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;

        int result = 0;
        boolean negative = false;
        if (str == null || str.trim().length() <= 0) {
            return result;
        }
        String trim = str.trim();
        char firstChar = trim.charAt(0);
        if ('+' == firstChar) {
            negative = false;
        } else if ('-' == firstChar) {
            negative = true;
        } else if (!Character.isDigit(firstChar)) {
            return 0;
        } else {
            result = firstChar - '0';
        }

        for (int i = 1; i < trim.length(); i++) {
            if (!Character.isDigit((trim.charAt(i)))) {
                break;
            }
            //校验是否超过最大值和最小值
            if (Math.abs(result) > maxValue / 10 || (Math.abs(result) == maxValue / 10 && Math.abs(trim.charAt(i) -'0') > maxValue % 10)) {
                return negative ? minValue : maxValue;
            }

            //下面两个条件判断可以用上面一个判断代替
            //if ((negative ? -result : result) > maxValue / 10 || ((negative ? -result : result) == maxValue / 10 && trim.charAt(i) - '0' > maxValue % 10)) {
            //    return Integer.MAX_VALUE;
            //}
            //
            //if ((negative ? -result : result) < minValue / 10 || ((negative ? -result : result) == minValue / 10) && trim.charAt(i) - '0' < minValue % 10) {
            //    return Integer.MIN_VALUE;
            //}
            result = result * 10 + trim.charAt(i) - '0';
        }
        return negative ? -result : result;
    }

    @Test
    public void test1() {
        Assert.assertEquals(0, myAtoi(""));
        Assert.assertEquals(123, myAtoi("  123"));
        Assert.assertEquals(-123, myAtoi("  -123"));
        Assert.assertEquals(-2147483648, myAtoi("-91283472332"));
        Assert.assertEquals(2147483646, myAtoi("2147483646"));
    }

    @Test
    public void test2() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE-1);
    }
}
