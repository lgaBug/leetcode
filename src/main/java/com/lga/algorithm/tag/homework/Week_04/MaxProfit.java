package com.lga.algorithm.tag.homework.Week_04;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i]<prices[i+1]) max += prices[i + 1] - prices[i];
        }
        return max;
    }

}
