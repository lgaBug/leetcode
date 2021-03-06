package com.lga.datastruct.lru;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int x) {
        val = x;
    }

    public static void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val +"->");
            head = head.next;
        }
    }

}
