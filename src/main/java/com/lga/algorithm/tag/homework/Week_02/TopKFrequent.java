package com.lga.algorithm.tag.homework.Week_02;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {

    /**
     *构建一个大小为K的小顶堆
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent_minHeap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        //将nums 中的数字和出现的频率构建一个哈希表
        for (int num : nums) {
            map.put(num, map.get(num) != null? map.get(num) + 1 : 1);
        }

        //构建一个小顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue(k, new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(mapEntry);
            }else{
                if (minHeap.peek().getValue() < mapEntry.getValue()) {
                    minHeap.poll();
                    minHeap.add(mapEntry);
                }
            }
        }

        //获取小顶堆中的值，
        while (!minHeap.isEmpty() && k-->0) {
            ans[k] = minHeap.poll().getKey();
        }
        return ans;
    }



    @Test
    public void test_topKFrequent_minHeap() {

        Assert.assertTrue(Arrays.equals(new int[]{2,-1},topKFrequent_minHeap(new int[]{4,1,-1,2,-1,2,3},2)));
    }
}
