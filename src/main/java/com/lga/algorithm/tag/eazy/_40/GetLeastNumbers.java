package com.lga.algorithm.tag.eazy._40;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 40. 最小的k个数
 *
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers {




    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        //构建一个大顶堆
        Queue<Integer> heap = new PriorityQueue<>(((v1, v2) -> v2 - v1));
        for (int num : arr) {
            if (heap.size() <k){
                heap.add(num);
            }else if (num <= heap.peek()) {
                heap.poll();
                heap.add(num);
            }
        }

        //返回队中的元素到数组中
        int[] ans = new int[heap.size()];
        int i = 0;
        while (!heap.isEmpty()) {
            ans[i++] = heap.poll();
        }
        return ans;
    }


    @Test
    public void test() {

        Queue<Integer> pq = new PriorityQueue<>(5);

        pq.add(1);
        pq.add(2);
        pq.add(10);
        pq.add(4);
        pq.add(7);
        pq.add(6);
        pq.add(11);



    }
}
