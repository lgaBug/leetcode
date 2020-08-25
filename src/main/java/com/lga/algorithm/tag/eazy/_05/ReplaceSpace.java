package com.lga.algorithm.tag.eazy._05;

import org.junit.Assert;
import org.junit.Test;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class ReplaceSpace {

    /**
     * 使用java自带的api替换
     * @param s
     * @return
     */
    public String replaceSpace_1(String s) {
        return s.replaceAll(" ", "%20");
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuffer sf = new StringBuffer();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c != ' ') {
                sf.append(c);
            }else{
                sf.append("%20");
            }
        }
        return sf.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("We%20are%20happy.",replaceSpace("We are happy."));
    }
}
