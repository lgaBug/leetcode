package com.lga.algorithm.tag.eazy.reverse_7;

import org.junit.Assert;
import org.junit.Test;

/**
 * 7. 整数反转
 * subject description:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * case 1:
 * 输入: 123
 * 输出: 321
 *
 * case 2:
 * 输入: -123
 * 输出: -321
 *
 * case 3:
 * 输入: 120
 * 输出: 21
 *
 * topic:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {

    public int reverse(int x) {
        int result = 0;
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;

        while (x != 0) {
            int temp = x % 10;

            if (Math.abs(result) > maxValue / 10 || (Math.abs(result) == maxValue / 10 && Math.abs(temp) > maxValue % 10)) {
                return 0;
            }

            //下面的两个判断可以直接用上面的替换
            //if (result > maxValue / 10 || (result == maxValue / 10 && temp > maxValue % 10)) {
            //    return 0;
            //}

            //if (result < minValue / 10 || (result == minValue / 10) && temp < minValue % 10) {
            //    return 0;
            //}
            result = result * 10 +temp;
            x /= 10;
        }
        return result;
    }

    @Test
    public void test1() {

        Assert.assertEquals(321,reverse(123));
        Assert.assertEquals(321,reverse(1230));
        Assert.assertEquals(-321,reverse(-123));
        Assert.assertEquals(0, reverse(Integer.MAX_VALUE));

    }

}
