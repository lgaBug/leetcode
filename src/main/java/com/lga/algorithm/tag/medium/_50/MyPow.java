package com.lga.algorithm.tag.medium._50;

import org.junit.Assert;
import org.junit.Test;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n >= 0) {
            return myPow_1(x, n);
        } else {
            n = -n;
            return 1 / myPow_1(x, n);
        }
    }

    private double myPow_1(double x, int n) {
        //终止条件
        if (n == 0) return 1;
        if (n == 1) return x;
        //处理当前逻辑
        double subans = myPow_1(x, n / 2);

        if (n % 2 == 0) {
            return subans * subans ;
        }
        return subans * subans * x;
    }

}
