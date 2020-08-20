package com.lga.algorithm.tag.medium._347;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * <p>
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];

        //统计每个数出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        //大顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(k, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> mapEntry : entries) {
            maxHeap.offer(mapEntry);
        }

        while (k > 0) {
            ans[ans.length - k--] = maxHeap.poll().getKey();
        }

        return ans;
    }



    @Test
    public void test1() {

        Assert.assertTrue(Arrays.equals(new int[]{1,2},topKFrequent(new int[]{1,1,1,2,2,3},2)));
    }

}
