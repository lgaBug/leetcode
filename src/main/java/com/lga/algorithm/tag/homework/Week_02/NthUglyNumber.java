package com.lga.algorithm.tag.homework.Week_02;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 剑指 Offer 49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class NthUglyNumber {

    /**
     * 构建最小堆依次弹出
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        int[] nums = new int[]{2, 3, 5};

        minHeap.add(1L);

        int count = 0;
        while (!minHeap.isEmpty()) {
            long cur = minHeap.poll();

            if(++count == n) return (int) cur;

            for (int num : nums) {
                if (!minHeap.contains(cur*num)) minHeap.add(cur * num);
            }

        }
        return -1;
    }
}
