package com.lga.algorithm.tag.search;


/**
 * 常见的查找算法
 */
public class Search {


    public static void main(String[] args) {

        final Search search = new Search();
        final int index = search.binarySearch2(new int[]{1, 2, 3, 4, 5, 6, 7}, 6);
        System.out.println("index = " + index);
    }


    /**
     * 二分查找算法、
     * 最简单的情况：假设有序数组中不存在重复的元素
     *
     * @param data
     * @return
     */
    public int binarySearch(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == target) {
                return mid;
            } else if (data[mid] > target) {
                right = mid - 1;
            } else if (data[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 二分查找的递归写法
     *
     * @param data
     * @param target
     * @return
     */
    public int binarySearch2(int[] data, int target) {
        return binarySearchInternal(data, 0, data.length - 1, target);
    }

    private int binarySearchInternal(int[] data, int left, int right, int target) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if (data[mid] == target) {
            return mid;
        } else if (data[mid] > target) {
            return binarySearchInternal(data, left, mid - 1, target);
        } else {
            return binarySearchInternal(data, mid + 1, right, target);
        }
    }

    /**
     * 求x的平方根
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;
        // 在区间 [left..right] 查找目标元素
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 注意：这里为了避免乘法溢出，改用除法
            if (mid > x / mid) {
                // 下一轮搜索区间是 [left..mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid..right]
                left = mid;
            }
        }
        return left;
    }
}
