package com.lga.algorithm.tag.eazy.plusone_66;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 66. 加一
 *
 * subject description:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * case 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * case 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public int[] plusOne_1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] !=0) return digits;
        }
        //当为99、999、99999的时候会加一需要将扩展数组大小
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }




    public int[] plusOne(int[] digits) {

        int len = digits.length;
        while (len-->0) {
            int temp = digits[len] + 1;
            if (temp % 10 == 0) {
                digits[len] = temp % 10;
            }else{
                digits[len] = temp;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
    @Test
    public void test1() {

        int[] result = plusOne(new int[]{1, 2, 3});
        Assert.assertTrue(Arrays.equals(result,new int[]{1,2,4}));
        int[] result1 = plusOne(new int[]{1, 9, 9});
        Assert.assertTrue(Arrays.equals(result1,new int[]{2,0,0}));
        int[] result2 = plusOne(new int[]{1, 2, 9});
        Assert.assertTrue(Arrays.equals(result2,new int[]{1,3,0}));
        int[] result3 = plusOne(new int[]{9, 9, 9});
        Assert.assertTrue(Arrays.equals(result3,new int[]{1,0,0,0}));
        int[] result4 = plusOne(new int[]{0});
        Assert.assertTrue(Arrays.equals(result4,new int[]{1}));



    }
}
