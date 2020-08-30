package com.lga.algorithm.tag.medium._1709;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 面试题 17.09. 第 k 个数
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 */
public class GetKthMagicNumber {

    public int getKthMagicNumber(int k) {
        Set<Long> set = new HashSet<>();
        Queue<Long> queue = new PriorityQueue<>();

        queue.add(1L);

        while (true) {
            Long curMin = queue.poll();
            if (!set.contains(curMin)) {
                set.add(curMin);
                queue.add(curMin * 3);
                queue.add(curMin * 5);
                queue.add(curMin * 7);
            }

            if (set.size() == k) {
                return curMin.intValue();
            }

        }
    }

    //todo 待进一步优化
    public int getKthMagicNumber_1(int k) {

        return 0;
    }

}
