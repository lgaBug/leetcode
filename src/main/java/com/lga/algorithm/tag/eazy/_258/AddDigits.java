package com.lga.algorithm.tag.eazy._258;

import org.junit.Assert;
import org.junit.Test;

/**
 * 258. 各位相加
 * https://leetcode-cn.com/problems/add-digits/
 */
public class AddDigits {

    public int addDigits(int num) {
        return sum((num + "").toCharArray());
    }

    private int sum(char[] nums) {
        int ans = 0;
        for (char num : nums) {
            ans += (num - '0');
        }
        if (ans < 10) return ans;
        return sum((ans + "").toCharArray());
    }

    /**
     * O(1)
     * @param num
     * @return
     */
    public int addDigits1(int num) {
        if (num == 0)
            return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }

    @Test
    public void test() {

        Assert.assertEquals(2, addDigits(38));
        Assert.assertEquals(2, addDigits(11));
        Assert.assertEquals(1, addDigits(10));

    }
}
