package com.lga.algorithm.tag.dp;

import org.junit.Test;

public class IsExistSum {

    public boolean rec_subset(int[] arr, int i, int s) {
        if (s == 0) return true;
        if (i == 0) return arr[i] == s;
        if (arr[i]>s) return rec_subset(arr, i - 1, s);
        return rec_subset(arr, i - 1, s - arr[i]) || rec_subset(arr, i - 1, s);
    }


    @Test
    public void test_rec_subset() {
        System.out.println(rec_subset(new int[]{1,2,3,4},3,5));
    }
}
