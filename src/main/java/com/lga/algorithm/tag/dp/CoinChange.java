package com.lga.algorithm.tag.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

    /**
     * 递归
     *
     * @param coins
     * @param amount
     * @return
     */
    private int ans = Integer.MAX_VALUE;

    public int coinChange_rec(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null) return -1;
        findWay(coins, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void findWay(int[] coins, int amount, int count) {
        if (amount < 0) return;
        if (amount == 0) ans = Math.min(ans, count);
        for (int coin : coins) {
            findWay(coins, amount - coin, count + 1);
        }
    }

    /**
     * 缓存重复的数据
     *
     * @param coins
     * @param amount
     * @return
     */
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange_cache(int[] coins, int amount) {
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coinValue : coins) {
            int subproblem = coinChange_cache(coins, amount - coinValue);
            if (subproblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subproblem);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        map.put(amount, res);
        return res;
    }


    public int coinChange_rec_01(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coinValue : coins) {
            int subproblem = coinChange_rec_01(coins, amount - coinValue);
            if (subproblem == -1) {
                continue;
            }
            res = Math.min(res, 1 + subproblem);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        return res;
    }

    public int coinChange_dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {

                if (i-coin<0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount+1?-1:dp[amount];
    }

}
