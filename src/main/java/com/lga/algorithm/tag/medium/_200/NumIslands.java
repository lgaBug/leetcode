package com.lga.algorithm.tag.medium._200;

/**
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int ans = 0;

        if (grid.length <= 0 || grid[0].length <= 0) {
            return ans;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length-1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}
