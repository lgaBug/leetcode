package com.lga.algorithm.tag.eazy._350;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        //不确定最终的结果是多少，所以先初始化一个相对较小的数组。
        int[] ans = new int[Math.min(nums2.length,nums1.length)];
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.containsKey(nums1[i]) ? map.get(nums1[i]) + 1 : 1);
        }
        //标记交集的个数
        int j = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                ans[j++] = nums2[i];
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        //System.arraycopy(ans, 0, ans, 0, j);
        //Arrays.copyOf(ans, j);
        return Arrays.copyOf(ans, j);
    }

    @Test
    public void test() {
        Assert.assertNull(intersect(null, null));

        Assert.assertTrue(Arrays.equals(new int[]{2, 2}, intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));

        Assert.assertTrue(Arrays.equals(new int[]{9, 4}, intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));

        Assert.assertTrue(Arrays.equals(new int[]{6, 4}, intersect(new int[]{4, 7, 9, 7, 6, 7}, new int[]{5, 0, 0, 6, 1, 6, 2, 2, 4})));
    }

    @Test
    public void testArrayCopy() {
        int[] array = {1, 2, 3, 4, 5, 6};

        System.arraycopy(array,0,array,1,3);

        System.out.println(Arrays.toString(array));
    }

}
