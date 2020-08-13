package com.lga.algorithm.tag.medium.swapPairs_24;

import com.lga.datastruct.lru.ListNode;
import org.junit.Test;

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

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode swapPairs_1(ListNode head) {
        if (head == null || head.next ==null) return head;
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs_1(second.next);
        second.next = first;
        return second;
    }

    /**
     * 遍历法
     */
    public ListNode swapPairs_2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevNode = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            first.next = head.next.next;
            second.next = first;
            prevNode.next = second;
            prevNode = first;
            head = first.next;
        }
        return dummy.next;
    }

    @Test
    public void test1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        swapPairs_2(listNode1);

    }




}
