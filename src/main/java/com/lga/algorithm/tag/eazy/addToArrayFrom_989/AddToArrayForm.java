package com.lga.algorithm.tag.eazy.addToArrayFrom_989;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * <p>
 * subject description:
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * case 1:
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * <p>
 * case 2:
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * <p>
 * case 3:
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * <p>
 * case 4:
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * <p>
 * topic：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 */
public class AddToArrayForm {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> resultList = new ArrayList<Integer>();
        int temp = 0;
        for (int i = A.length - 1; (i >= 0 || K != 0); i--) {
            if (i < 0) {
                temp = K;
            } else {
                temp = A[i] + K;
            }
            resultList.add(temp % 10);
            K = temp / 10;
        }
        Collections.reverse(resultList);
        return resultList;
    }

    /**
     * 无法执行，常规方法不可行
     *
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm1(int[] A, int K) {
        int num = 0;
        int addAfterNum = 0;
        for (int i = 0; i < A.length; i++) {
            num = A[i] + num * 10;
        }
        addAfterNum = num + K;
        String addAfterStr = addAfterNum + "";
        List<Integer> resultList = new ArrayList<Integer>(addAfterStr.length());
        for (int i = 0; i < addAfterStr.length(); i++) {
            resultList.add(addAfterStr.charAt(i) - '0');
        }
        return resultList;
    }

    @Test
    public void test1() {

        List<Integer> result = addToArrayForm(new int[]{1, 2, 0, 0}, 34);
        Assert.assertEquals(new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
            }
        }, result);

        List<Integer> result1 = addToArrayForm(new int[]{2, 7, 4}, 181);
        Assert.assertEquals(new ArrayList<Integer>() {
            {
                add(4);
                add(5);
                add(5);
            }
        }, result1);

        List<Integer> result2 = addToArrayForm(new int[]{2, 1, 5}, 806);
        Assert.assertEquals(new ArrayList<Integer>() {
            {
                add(1);
                add(0);
                add(2);
                add(1);
            }
        }, result2);

        List<Integer> result3 = addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1);
        Assert.assertEquals(new ArrayList<Integer>() {
            {
                add(1);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
                add(0);
            }
        }, result3);

        List<Integer> result4 = addToArrayForm(new int[]{0}, 0);
        Assert.assertEquals(new ArrayList<Integer>() {
            {
                add(0);
            }
        }, result4);

    }

}
