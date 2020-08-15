package com.lga.algorithm.tag.eazy.getHint_200;

import org.junit.Assert;
import org.junit.Test;

/**
 * 299. 猜数字游戏
 * https://leetcode-cn.com/problems/bulls-and-cows/
 */
public class GetHint {

    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] arr = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                arr[secret.charAt(i) - '0']++;
                arr[guess.charAt(i) - '0']--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                b += arr[i];
            }
        }
        b = guess.length() - b - a;
        return a + "A" + b + "B";
    }

    @Test
    public void test1() {

        Assert.assertEquals("0A1B", getHint("1234", "0110"));
        Assert.assertEquals("1A3B", getHint("1807", "7810"));
        Assert.assertEquals("1A1B", getHint("1123", "0111"));

    }
}
