package com.lga.algorithm.tag.eazy._412;

import java.util.LinkedList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * https://leetcode-cn.com/problems/fizz-buzz/
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        List<String> ans = new LinkedList<>();
        int i = 0;
        while (++i <= n) {
            if (i % 15 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(""+i);
            }
        }
        return ans;
    }

}
