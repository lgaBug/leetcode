package com.lga.algorithm.tag.eazy._7._860;

import java.util.HashMap;
import java.util.Map;

/**
 * 860. 柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/
 */
public class LemonadeChange {

    /**
     * 暴力法
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        boolean falg = false;
        Map<Integer, Integer> hash = new HashMap();
        hash.put(5, 0);
        hash.put(10, 0);
        hash.put(20, 0);

        int cur = 0;
        for (int bill : bills) {
            if (bill == 5) {
                hash.put(bill, hash.get(bill) + 1);
                continue;
            } else if (bill == 10) {
                if (hash.get(5) < 1) {
                    return false;
                } else {
                    hash.put(5, hash.get(5) - 1);
                    hash.put(bill, hash.get(bill) + 1);
                }
            } else if (bill == 20) {
                if (hash.get(5) < 1) {
                    return false;
                } else if (hash.get(5) < 3 && hash.get(10) < 1) {
                    return false;
                } else if (hash.get(10) > 0) {
                    hash.put(10, hash.get(10) - 1);
                    hash.put(5, hash.get(5) - 1);
                    hash.put(bill, hash.get(bill) + 1);
                } else if (hash.get(5) > 2) {
                    hash.put(5, hash.get(5) - 3);
                    hash.put(bill, hash.get(bill) + 1);
                }
            }
        }
        return true;
    }

    /**
     * 暴力法_优化
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange_1(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
