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
     * 归并排序
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

}
