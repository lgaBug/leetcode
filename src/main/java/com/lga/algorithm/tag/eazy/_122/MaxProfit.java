package com.lga.algorithm.tag.eazy._122;

import org.junit.Assert;
import org.junit.Test;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit {

    /**
     * 暴力法 O(n^2)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int j = i;
            for (; j < prices.length - 1; j++) {
                if (prices[j] <= prices[j + 1]) continue;
                break;
            }
            if (j == i) continue;
            ans += prices[j] - prices[i];
            i = j;
        }

        return ans;
    }

    /**
     * 暴力法_优化 、贪心算法 O(n)
     * @param prices
     * @return
     */
    public int maxProfit_1(int[] prices) {
        int ans = 0;
        for(int i =0;i<prices.length-1;i++){
            if(prices[i] < prices[i+1]){
                ans +=prices[i+1] -prices[i];
            }
        }
        return ans;

    }

    @Test
    public void test() {
        Assert.assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
