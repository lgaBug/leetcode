package com.lga.algorithm.tag.eazy._121;

public class MaxProfit {


    /**
     * 暴力法
     */
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    /**
     * 一次遍历
     */
    public int maxProfit_1(int prices[]) {
        int maxprofit = 0;
        int minValue = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price<minValue) minValue = price;
            if (price-minValue > maxprofit) {
                maxprofit = price - minValue;
            }
        }
        return maxprofit;
    }
}
