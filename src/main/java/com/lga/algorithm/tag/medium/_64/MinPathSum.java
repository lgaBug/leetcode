package com.lga.algorithm.tag.medium._64;

import org.junit.Test;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinPathSum {

    /**
     * 傻递归
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int[][] arrs = new int[grid.length][grid[0].length];
        opt(grid, grid.length - 1, grid[0].length - 1, arrs);
        return arrs[grid.length - 1][grid[0].length - 1];
    }

    private int opt(int[][] grid, int i, int j, int[][] arrs) {
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

    @Test
    public void test() {
        int ans = minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println("ans = " + ans);
    }
}
