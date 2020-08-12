package com.lga.algorithm.tag.eazy.ispalindrome_234;

import com.lga.datastruct.lru.ListNode;
import org.junit.Assert;
import org.junit.Test;
import sun.java2d.pipe.SpanIterator;

import java.util.List;
import java.util.Stack;

/**
 * 234. 回文链表
 * <p>
 * subject description:
 * 请判断一个链表是否为回文链表。
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>
 * case 1:
 * 输入: 1->2
 * 输出: false
 * <p>
 * case 2:
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head; // 一快一慢两个指针，为了找到需要翻转的半条链表的起点。遍历半个链表
        ListNode fast = head;
        ListNode pre = null; // 用于辅助翻转前半条链表
        while (fast != null && fast.next != null) {
            ListNode cur = slow;
            slow = slow.next;
            fast = fast.next.next;
            cur.next = pre;
            pre = cur;
        }
        if (fast != null) slow = slow.next; //当个数为奇数的时候，中间的数不需要比较/
        while (pre != null) { // 两个半长链表的比较 遍历两个 半长链表
            if (pre.val != slow.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }

    //使用快慢指针
    public boolean isPalindrome1(ListNode head) {

        if (head == null || head.next == null) return true;
        //快指针
        ListNode f = head;
        //慢指针
        ListNode s = head;
        ListNode temp = null;

        //反转慢指针遍历过的值
        while (f != null && f.next != null) {
            ListNode cur = s;
            s = s.next;
            f = f.next.next;
            cur.next = temp;
            temp = cur;
        }
        //当总结点数为奇数时，中间的值不需要比较，所有慢指针需求取下一个节点
        if (f != null) {
            s = s.next;
        }

        //比较temp 和 s 链表的数据
        while (s != null) {
            if (s.val != temp.val) return false;
            s = s.next;
            temp = temp.next;
        }

        return true;
    }

    @Test
    public void test1() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        Assert.assertEquals(true, isPalindrome1(listNode));
    }

    @Test
    public void test2() {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(2);
        listNode1.next.next.next = new ListNode(3);
        Assert.assertEquals(false, isPalindrome1(listNode1));
    }

    @Test
    public void test3() {
        ListNode listNode3 = new ListNode(3);
        listNode3.next = new ListNode(0);
        listNode3.next.next = new ListNode(0);
        Assert.assertEquals(false, isPalindrome1(listNode3));
    }

}
