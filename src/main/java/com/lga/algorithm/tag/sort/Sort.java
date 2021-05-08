package com.lga.algorithm.tag.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 常用的排序算法
 */
public class Sort {



    // 冒泡排序，a表示数组，n表示数组大小
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }


    /**
     * 插入排序,O(n^2) O(1) 原地稳定的排序算法
     *
     * @param arr
     */
    public void insertSort(int[] arr) {
        if (arr.length <= 1) return;
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j > -1) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    /**
     * 归并排序 时间复杂度O(nlogn)
     * @param arr
     */
    public void mergeSort(int[] arr) {
        mergesort_part(arr, 0, arr.length - 1);
    }

    private void mergesort_part(int[] arr, int p, int r) {
        if (p >= r) return;

        //获取中间的位置
        int q = p + (r - p)/2;

        //分冶递归
        mergesort_part(arr, p, q);
        mergesort_part(arr, q + 1, r);

        //合并
        merge(arr, p, q, r);

    }

    private void merge(int[] arr, int p, int q, int r) {

        int i = p;
        int j = q + 1;
        int k = 0;
        int[] temp = new int[r - p+1];

        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        //将多余的数据拷贝到temp中
        while (start <= end) {
            temp[k++] = arr[start++];
        }

        //值回写给arr
        for (int num : temp) {
            arr[p++] = num;
        }

    }

    /**
     * 快速排序算法
     * @param arr
     */
    public void quickSort(int[] arr) {
        quickSort_part(arr,0,arr.length-1);
    }

    private void quickSort_part(int[] arr, int p, int r) {
        if(p>=r) return;
        int q = partition(arr, p, r);
        quickSort_part(arr, p, q-1);
        quickSort_part(arr, q + 1, r);
    }

    private int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        return i;
    }

    @Test
    public void test_insertSort() {
        int[] arr = new int[]{3, 2, 1, 6, 4, 5};
        insertSort(arr);
        Assert.assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5, 6}, arr));
    }

    @Test
    public void test_mergeSort() {
        int[] arr = new int[]{3, 2, 1, 6, 4, 5};
        mergeSort(arr);
        Assert.assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5, 6}, arr));
    }

    @Test
    public void test_quickSort() {
        int[] arr = new int[]{3, 2, 1, 6, 4, 5};
        quickSort(arr);
        Assert.assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5, 6}, arr));
    }


    @Test
    public void test_bubbleSort() {
        int[] arr = new int[]{3, 2, 1, 6, 4, 5};
        bubbleSort(arr,arr.length);
        Assert.assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5, 6}, arr));
    }

}
