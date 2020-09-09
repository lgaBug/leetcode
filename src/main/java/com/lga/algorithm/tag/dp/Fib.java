package com.lga.algorithm.tag.dp;

import org.junit.Test;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Fib {

    /**
     * 递归写法
     * O(2^n)
     * @param n
     * @return
     */
    public int fib_rec(int n) {
        if (n == 0 || n == 1) return n;
        return (fib_rec(n - 2)%1000000007 + fib_rec(n - 1)%1000000007)%1000000007;
    }

    /**
     * 自顶向下
     * 用数组缓存已经计算过的值
     * @param n
     * @return
     */
    public int fib_cache(int n) {
        int[] cache = new int[n+1];
        return helper(n, cache);
    }

    private int helper(int n, int[] cache) {
        if (n == 0 || n ==1) return n;
        if(cache[n] != 0) return cache[n];
        return cache[n] =  (helper(n - 1,cache)%1000000007 + helper(n - 2,cache)%1000000007)%1000000007;
    }

    /**
     * 动态规划，自底向上
     * @param n
     * @return
     */
    private int fib_dp(int n) {
        if(n == 0 || n == 1) return n;
        int[] cache = new int[n + 1];
        int i = 0;
        while (i < 2) {
            cache[i] = i++;
        }
        while (i<=n){
            cache[i] = (cache[i - 2] + cache[i - 1])%1000000007;
            i++;
        }
        return cache[n];
    }

    /**
     * dp 优化，中间状态无需保存。
     * @param n
     * @return
     */
    private int fib_dp_optimized(int n) {
        if(n == 0 || n == 1) return n;
        int first = 0;
        int second = 1;
        int cur = 1;
        int i = 2;
        while (i++<=n){
            cur = (first + second)%1000000007;
            first = second;
            second = cur;
        }
        return cur;
    }


    @Test
    public void test() {
        fib_dp(1);
    }
}
