package com.lga.algorithm.tag.eazy.fib_509;

/**
 * subject description: 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * <p>
 * case 1:
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * case 2:
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class Fib {

    public static int fib(int n) {

        if (n == 0) {
            return 0;
        }

        int preOfPre = 0;
        int pre = 0;
        int cur = 1;

        for (int i = 2; i <= n; i++) {
            preOfPre = pre;
            pre = cur;
            cur = preOfPre + pre;
        }

        return cur;

    }
}
