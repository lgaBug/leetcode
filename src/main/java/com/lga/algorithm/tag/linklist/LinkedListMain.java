package com.lga.algorithm.tag.linklist;


import com.lga.algorithm.tag.eazy._234.IsPalindrome;
import com.lga.datastruct.lru.ListNode;

import java.util.List;

/**
 * 链表相关的题目
 */
public class LinkedListMain {


    public static void main(String[] args) {


//        ListNode listNode5 = new ListNode(1);
//        ListNode listNode4 = new ListNode(2, listNode5);
//        ListNode listNode3 = new ListNode(3, listNode4);
//        ListNode listNode2 = new ListNode(2, listNode3);
//        ListNode listNode1 = new ListNode(1, listNode2);
//
//        System.out.println("isPalindrome = " + isPalindrome(listNode1));


        // ======================================================================================================


        ListNode listNode3 = new ListNode(4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode6 = new ListNode(4);
        ListNode listNode5 = new ListNode(3,listNode6);
        ListNode listNode4 = new ListNode(1, listNode5);

        final ListNode listNode = mergeTwoLists(listNode1, listNode4);

        ListNode.print(listNode);


    }


    /**
     * 234.回文链表
     * 快慢指针 + 翻转链表解法
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode f = head;
        ListNode s = head;
        //翻转后的链表
        ListNode dummy = null;

        while (f != null && f.next != null) {
            ListNode cur = s;
            f = f.next.next;
            s = s.next;
            cur.next = dummy;
            dummy = cur;
        }

        // 为奇数时，中间不用比较
        if (f != null) {
            s = s.next;
        }

        while (s != null && dummy != null) {
            if (s.val != dummy.val) {
                return false;
            }
            s = s.next;
            dummy = dummy.next;
        }

        return true;
    }


    /**
     * 21 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 == null ? l2 : l1;

        return dummy.next;
    }

}
