package com.lga.algorithm.tag.dp._62;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) graph[i][j] = 1;
                else graph[i][j] = graph[i - 1][j]+graph[i][j-1];
            }
        }
        return graph[n - 1][m - 1];
    }
}
