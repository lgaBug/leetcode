package com.lga.algorithm.tag.homework.Week_04;

/**
 * 367. 有效的完全平方数
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if(num<2) return true;

        long left = 2;
        long right = num/2;

        while(left <= right){
            long mid = left + (right -left)/2;
            if(mid * mid == num) return true;
            else if(mid * mid > num) right = mid -1;
            else left = mid + 1;
        }
        return false;
    }
}
