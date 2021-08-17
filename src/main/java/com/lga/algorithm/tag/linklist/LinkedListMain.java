package com.lga.algorithm.tag.linklist;


import com.lga.algorithm.tag.eazy._234.IsPalindrome;
import com.lga.datastruct.lru.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 链表相关的题目
 */
public class LinkedListMain {


    public static void main(String[] args) {

        final LinkedListMain linkedListMain = new LinkedListMain();
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

//
        ListNode.print(linkedListMain.rotateRight(listNode1,2));


        // ======================================================================================================




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
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 == null ? l2 : l1;

        return dummy.next;
    }


    /**
     * 83 删除排序链表中的重复元素
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        Set<ListNode> set = new HashSet();

        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }


        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }


    /**
     * 203. 移除链表元素
     * 通过哨兵简化边界情况
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        ListNode dummy = new ListNode(-1, head);

        ListNode pre = dummy;

        while (head != null) {
            if (val == head.val) {
                pre.next = pre.next.next;
                head = head.next;
                continue;
            }
            pre = pre.next;
            head = head.next;
        }

        return dummy.next;
    }


    /**
     * 206. 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode dummy = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;

            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }


    /**
     * 24. 两两交换链表中的节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;

    }


    /**
     * 61. 旋转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        int length = 0;

        ListNode dummy = head;
        ListNode tail = null;

        while(head != null){
            length++;
            tail = head;
            head = head.next;
        }

        int count = (Math.abs(k>length?k-length:length-k))%length;

        tail.next = dummy;
        ListNode pre = tail;

        while(count-- > 0){
            dummy = dummy.next;
            pre = pre.next;
        }

        pre.next = null;

        return dummy;
    }

    /**
     * 25. K 个一组翻转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null) return null;
        ListNode a = head,b=head;

        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newNode = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return newNode;
    }

    private ListNode reverse(ListNode a,ListNode b){
        ListNode pre = null,next = a,cur = a;
        while(cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
