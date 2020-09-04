package com.lga.algorithm.tag.eazy._455;

import java.util.Arrays;

/**
 * 455. 分发饼干 贪心算法
 * https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = 0; i < s.length && ans < g.length; i++) {
            if (g[ans] <= s[i]) {
                ans++;
            }
        }
        return ans;
    }
}
