package com.lga.algorithm.tag.dp;

/**
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int steps[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        //初始化第一列，只要碰到一个1，那么后边都无法走到
        for(int i=0;i<obstacleGrid.length;i++){
            if(obstacleGrid[i][0]==1){break;}
            steps[i][0]=1;
        }
        //初始化第一行，只要碰到一个1，那么后边都无法走到
        for(int j=0;j<obstacleGrid[0].length;j++){
            if(obstacleGrid[0][j]==1){break;}
            steps[0][j]=1;

        }
        //在没有障碍物的情况下，到达某一点只能从左边或者上边
        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[0].length;j++){
                steps[i][j]=obstacleGrid[i][j]==1?0:steps[i-1][j]+steps[i][j-1];
            }
        }
        return steps[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
