package com.lga.algorithm.tag.homework.Week_01;

import com.lga.datastruct.lru.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 21. 合并两个有序链表
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {

    /**
     * recusion
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val >= l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    /**
     * 暴力破解法
     *时间复杂度O(n)
     * 空间复杂度O(n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {

        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) dummy.next = l1;
        if (l2 != null) dummy.next = l2;

        return ans.next;
    }

    @Test
    public void test() {

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        int[] arr = new int[]{1, 1, 2, 3, 4, 4};
        ListNode result = mergeTwoLists(l1, l2);
        int i = 0;
        while (result != null) {
            Assert.assertTrue(result.val == arr[i++]);
            result = result.next;
        }

    }

    @Test
    public void test1() {

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        int[] arr = new int[]{1, 1, 2, 3, 4, 4};
        ListNode result = mergeTwoLists_1(l1, l2);
        int i = 0;
        while (result != null) {
            Assert.assertTrue(result.val == arr[i++]);
            result = result.next;
        }

    }
}