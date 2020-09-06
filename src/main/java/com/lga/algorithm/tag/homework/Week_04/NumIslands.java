package com.lga.algorithm.tag.homework.Week_04;

import org.junit.Test;

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
                    helper(i, j, grid);
                }
            }
        }
        return ans;
    }

    private void helper(int i, int j,char[][] grid){
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        helper(i+1,j,grid);
        helper(i-1,j,grid);
        helper(i,j+1,grid);
        helper(i,j-1,grid);
    }

    @Test
    public void test() {
        int ans = numIslands(new char[][]{new char[]{'1', '1', '0', '0', '0'}, new char[]{'1', '1', '0', '0', '0'}, new char[]{'0', '0', '1', '0', '0'}, new char[]{'0', '0', '0', '1', '1'}});
        System.out.println("ans = " + ans);
    }
}
