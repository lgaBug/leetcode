package com.lga.algorithm.tag.eazy._06;

import com.lga.datastruct.lru.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 */
public class ReversePrint {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] ans = new int[stack.size()];
        int i =0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }

        return ans;
    }

    @Test
    public void test_reversePrint() {
        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(3);
        ListNode root2 = new ListNode(2);
        root.next = root1;
        root1.next = root2;

        Assert.assertTrue(Arrays.equals(new int[]{2,3,1},reversePrint(root)));

    }

}
