package com.lga.algorithm.tag.dp;

import org.junit.Test;

/**
 * 求数组中不相邻的最大和
 */
public class NonAdjacentMaxSum {

    /**
     * 递归写法
     *
     * @param arr
     * @param i
     * @param cache
     * @return
     */
    public int rec_opt(int[] arr, int i, int[] cache) {
        if (cache[i] != 0) return cache[i];
        if (i == 0) return cache[i] = arr[i];
        if (i == 1) return cache[i] = Math.max(arr[0], arr[1]);
        return cache[i] = Math.max(rec_opt(arr, i - 2, cache) + arr[i], rec_opt(arr, i - 1, cache));
    }

    /**
     * 非递归写法，动态规划
     *
     * @param arr
     * @param i
     * @return
     */
    public int dp_opt(int[] arr, int i) {
        //用于保存到第i个最大的值
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);

        int j = 2;
        while (j <= i) {
            int select = opt[j - 2] + arr[j];
            int notSelet = opt[j - 1];
            opt[j] = Math.max(select, notSelet);
            j++;
        }
        return opt[i];
    }

    @Test
    public void test_dp() {
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        System.out.println(dp_opt(arr, arr.length - 1));
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        System.out.println(rec_opt(arr, arr.length - 1, new int[arr.length]));
    }

}
