package com.lga.algorithm.tag.eazy.minstack_155;

/**
 * 155. 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 */
public class MinStack {

    /**
     * initialize your data structure here.
     */

    private Node head;

    public MinStack() {
    }

    public void push(int x) {
        if(head ==null){
            head = new Node(x, x);
        }else{
            Node temp = new Node(x, Math.min(x, head.min));
            temp.next = head;
            head = temp;
        }
    }

    public void pop() {
        if (head !=null) head = head.next;
    }

    public int top() {
        if(head !=null)
            return head.value;
        return -1;
    }

    public int getMin() {

        if (head !=null)
            return head.min;
        return -1;
    }

    class Node {
        int value;
        int min;
        Node next;

        Node(int x, int min) {
            this.value = x;
            this.min = min;
            next = null;
        }
    }

}
