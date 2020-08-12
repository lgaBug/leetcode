package com.lga.algorithm.tag.medium.swapPairs_24;

import com.lga.datastruct.lru.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * subject description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * case 1:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;

    }
}
