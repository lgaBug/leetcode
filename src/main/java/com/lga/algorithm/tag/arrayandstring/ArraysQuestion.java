package com.lga.algorithm.tag.arrayandstring;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysQuestion {

    /**
     * 寻找数组的中心索引
     */

    public int pivotIndex(int[] nums) {
        int sum = getSum(nums);
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {

            if (leftSum * 2 + nums[i] == sum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    private int getSum(int[] nums) {
        if (nums == null) return 0;
        return Arrays.stream(nums).parallel().reduce(0, Integer::sum);
    }

    /**
     * 合并区间
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;

        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            }else{
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res,idx+1);
    }

    /**
     * 旋转矩阵
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] res = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                res[j][length - i - 1] = matrix[i][j];
            }
        }
        System.arraycopy(res,0,matrix,0,length);
    }

}
