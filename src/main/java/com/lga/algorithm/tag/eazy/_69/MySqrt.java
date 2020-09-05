package com.lga.algorithm.tag.eazy._69;

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class MySqrt {

    /**
     * 二分查找
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0 || x== 1) return x;
        long left = 1L;
        long right = Long.valueOf(x);

        while (left <= right) {
            //左中位数
            long mid = left + (right - left) / 2;
            long quart = Long.valueOf(mid * mid);
            if (quart > x) {
                right = mid - 1;
            } else {
                left = mid +1;
            }
        }
        return (int) right;
    }
}
