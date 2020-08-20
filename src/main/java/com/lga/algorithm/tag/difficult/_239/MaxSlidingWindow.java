package com.lga.algorithm.tag.difficult._239;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 */
public class MaxSlidingWindow {

    /**
     * 暴力法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int j = k;
            int curMax = nums[i];
            while (j-- > 0) {
                curMax = Math.max(curMax, nums[j + i]);
            }
            ans[i] = curMax;
        }
        return ans;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                monotonicQueue.push(nums[i]);
            } else {
                monotonicQueue.push(nums[i]);
                ans[i - k + 1] = monotonicQueue.max();
                monotonicQueue.pop(nums[i - k + 1]);
            }
        }
        return ans;
    }

    class MonotonicQueue {
        private LinkedList<Integer> data = new LinkedList<>();

        public void push(int e) {
            while (!data.isEmpty() && data.getLast() < e)
                data.removeLast();
            data.add(e);
        }

        public void pop(int e) {
            if (!data.isEmpty() && data.getFirst() == e) data.removeFirst();
        }

        public int max() {
            return data.getFirst();
        }

    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        //构建一个最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0, j = i - k + 1; i < nums.length; i++, j++) {
            maxHeap.offer(nums[i]);
            if (maxHeap.size() == k) {
                ans[j] = maxHeap.peek();
                maxHeap.remove(nums[j]);
            }
        }
        return ans;
    }

    @Test
    public void test1() {
        Assert.assertTrue(Arrays.equals(new int[]{3, 3, 2, 5}, maxSlidingWindow2(new int[]{1, 3, 1, 2, 0, 5}, 3)));
        Assert.assertTrue(Arrays.equals(new int[]{3, 3, -1, 5, 5, 6, 7}, maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 2)));
        Assert.assertTrue(Arrays.equals(new int[]{3, 3, 5, 5, 6, 7}, maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        Assert.assertTrue(Arrays.equals(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 1)));
    }

}
