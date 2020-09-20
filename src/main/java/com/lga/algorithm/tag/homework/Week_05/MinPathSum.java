package com.lga.algorithm.tag.homework.Week_05;

/**
 * 64. 最小路径和
 * <p>
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {

    /**
     * 常规dp
     * 时间复杂度O（n^2）
     * 空间复杂度O（n）
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1) return 0;
        int y = grid.length;
        int x = grid[0].length;
        int[][] dp = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if (i == 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if (j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[y - 1][x - 1];
    }

    /**
     * 优化常规dp。可以不需要额外的空间来保存状态
     * @param grid
     * @return
     */
    public int minPathSum_1(int[][] grid) {
        if (grid == null || grid.length < 1) return 0;
        int y = grid.length;
        int x = grid[0].length;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[y - 1][x - 1];
    }
}
