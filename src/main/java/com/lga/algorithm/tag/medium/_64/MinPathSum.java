package com.lga.algorithm.tag.medium._64;

import org.junit.Test;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {

    /**
     * 递归+cache
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int[][] arrs = new int[grid.length][grid[0].length];
        return opt(grid, grid.length - 1, grid[0].length - 1, arrs);
    }

    private int opt(int[][] grid, int i, int j, int[][] arrs) {
        if (arrs[i][j] != 0) return arrs[i][j];
        if (i == 0 && j == 0) {
            return arrs[i][j] = grid[i][j];
        } else if (j == 0 && i != 0) {
            return arrs[i][j] = opt(grid, i - 1, j, arrs) + grid[i][j];
        } else if (i == 0 && j != 0) {
            return arrs[i][j] = opt(grid, i, j - 1, arrs) + grid[i][j];
        } else {
            return arrs[i][j] = Math.min(opt(grid, i - 1, j, arrs), opt(grid, i, j - 1, arrs)) + grid[i][j];
        }
    }

    /**
     * dp 解法
     *
     * @param grid
     * @return
     */
    public int minPathSum_dp(int[][] grid) {
        if (grid == null) return 0;
        int ylen = grid.length;
        int xlen = grid[0].length;
        for (int i = 0; i < ylen; i++) {
            for (int j = 0; j < xlen; j++) {
                if (i == 0) continue;
                if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0 && i > 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }
        return grid[ylen - 1][xlen - 1];
    }

    @Test
    public void test() {
        int ans = minPathSum_dp(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println("ans = " + ans);
    }
}
