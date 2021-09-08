package com.lga.algorithm.tag.arrayandstring;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

    /**
     * 旋转矩阵
     *
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
        System.arraycopy(res, 0, matrix, 0, length);
    }

    /**
     * 零矩阵
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        boolean[] row = new boolean[matrix.length];
        boolean[] clomn = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    clomn[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || clomn[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }


    /**
     * 移动零
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        //统计零的个数
        int zeroCount = 0;
        //记录当前不为0的位置
        int cur = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0){
                zeroCount++;
            }  else{
                nums[cur++] = nums[i];
            }
        }

        while (zeroCount > 0) {
            nums[len - zeroCount--] = 0;
        }

    }

    /**
     * 76. 最小覆盖子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap();
        Map<Character,Integer> window = new HashMap();

        for(char c: t.toCharArray()) {
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))) valid ++;
            }

            //当窗口符合要求时
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                Character d = s.charAt(left);
                left++;

                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }

        return len == Integer.MAX_VALUE?"":s.substring(start,len+start);
    }

    public static void main(String[] args) {

        final ArraysQuestion arraysQuestion = new ArraysQuestion();
        final String s = arraysQuestion.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("s = " + s);
    }

}
