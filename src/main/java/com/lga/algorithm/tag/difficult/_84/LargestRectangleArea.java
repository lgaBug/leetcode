package com.lga.algorithm.tag.difficult._84;

import org.junit.Assert;
import org.junit.Test;

/**
 * 84. 柱状图中最大的矩形
 * <p>
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleArea {

    /**
     * 暴力破解 1
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int maxArea = heights[0];
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
            }
        }

        return maxArea;
    }

    /**
     * 加速暴力破解 2
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea_2(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int maxArea = heights[0];
        for (int i = 0; i < heights.length; i++) {
            int left = i - 1;
            int right =i + 1;

            while (left > -1) {
                if (heights[left] >= heights[i]){
                    left--;
                    continue;
                }
                break;
            }

            while (right < heights.length) {
                if (heights[right] >= heights[i]) {
                    right++;
                    continue;
                }
                break;
            }
            maxArea = Math.max(maxArea, heights[i] * (right - left-1));

        }
        return maxArea;
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, largestRectangleArea_2(new int[]{2,3}));
        Assert.assertEquals(9, largestRectangleArea_2(new int[]{0,9}));
        Assert.assertEquals(0, largestRectangleArea_2(new int[]{}));
        Assert.assertEquals(2, largestRectangleArea_2(new int[]{2}));
        Assert.assertEquals(2, largestRectangleArea_2(new int[]{2, 1}));
        Assert.assertEquals(10, largestRectangleArea_2(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
