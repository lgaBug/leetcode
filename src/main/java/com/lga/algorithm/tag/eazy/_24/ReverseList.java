package com.lga.algorithm.tag.eazy._24;

import com.lga.datastruct.lru.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * 剑指 Offer 24. 反转链表
 *
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;

    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        head.print(reverseList(head));
    }
}
