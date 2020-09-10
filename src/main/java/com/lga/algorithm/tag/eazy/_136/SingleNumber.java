package com.lga.algorithm.tag.eazy._136;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 136. 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {

    /**
     * 哈希法
     *
     * @param nums
     * @return
     */
    public int singleNumber_hash(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }

    /**
     * 异或法 公式 a=a^b^b
     *
     * @param nums
     * @return
     */
    public int singleNumber_1(int[] nums) {
        int ans = nums[0];
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        return ans;
    }
}
