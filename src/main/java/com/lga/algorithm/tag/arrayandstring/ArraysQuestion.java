package com.lga.algorithm.tag.arrayandstring;

import java.util.*;
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

    /**
     * 567. 字符串的排列
     * @param t
     * @param s
     * @return
     */
    public boolean checkInclusion(String t, String s) {
        Map<Character,Integer> need = new HashMap();
        Map<Character,Integer> window = new HashMap();

        for(char c: t.toCharArray()) {
            need.put(c,need.getOrDefault(c,0)+1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        // 记录最小覆盖子串的起始索引及长度
        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;

            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))) valid ++;
            }

            while (right - left >= t.length()) {

                if (valid == need.size()) return true;

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

        return false;

    }

    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumTarget(nums,0);
    }

    private List<List<Integer>> threeSumTarget(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;

        for(int i =0; i < len; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums,i+1,target - nums[i]);

            for(List<Integer> tuple: tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }

            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < len - 1 && nums[i] == nums[i + 1]) i++;
        }

        return res;
    }

    private List<List<Integer>> twoSumTarget(int[] nums,int start, int target) {

        int left = start;
        int right = nums.length - 1;
        List<List<Integer>> res = new LinkedList<>();

        while (left < right) {

            int sum = nums[left] + nums[right];

            if (sum == target){
                LinkedList<Integer> re = new LinkedList<>();
                re.add(nums[left]);
                re.add(nums[right]);
                res.add(re);
                while (left < right && nums[left] == nums[left+1]) left++;
                while (left < right && nums[right] == nums[right-1]) right--;
                left++;
                right--;
            }else if(sum > target) {
                right--;
            }else if(sum < target) {
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        final ArraysQuestion arraysQuestion = new ArraysQuestion();
//        final String s = arraysQuestion.minWindow("ADOBECODEBANC", "ABC");
//        System.out.println("s = " + s);

//        arraysQuestion.checkInclusion("ab","eidboaoo");
        arraysQuestion.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

}
