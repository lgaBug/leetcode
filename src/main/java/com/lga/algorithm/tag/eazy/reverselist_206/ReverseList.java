package com.lga.algorithm.tag.eazy.reverselist_206;

import com.lga.datastruct.lru.ListNode;

/**
 * 206. 反转链表
 *
 * subject description:
 * 反转一个单链表。
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * case 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode ans = null;
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = ans;
            ans = cur;
        }
        return ans;
    }


    public ListNode reverseList_recursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }




}
