package com.lga.algorithm.tag.medium._74;

import org.junit.Test;

/**
 * 74. 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) return false;
        int len = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = len-1;
            //二分查找
            for (int j = 0; j < len && left <= right; j++) {
                int minIndex = left + (right - left) / 2;
                if (matrix[i][minIndex] == target) return true;
                if (matrix[i][minIndex] < target) {
                    left = minIndex + 1;
                    continue;
                }
                if (matrix[i][minIndex] > target) {
                    right = minIndex - 1;
                    continue;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        boolean ans = searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}}, 3);
        System.out.println("ans = " + ans);
    }
}
