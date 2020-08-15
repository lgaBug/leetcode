package com.lga.algorithm.tag.homework.Week_01;

import org.junit.Assert;
import org.junit.Test;

public class MyDeque<E> {

    private MyLinkNode<E> myLinkNode;

    public void addFirst(E e) {
        if (myLinkNode == null) {
            myLinkNode = new MyLinkNode<>(e);
        } else {
            MyLinkNode curLinkNode = new MyLinkNode(e, myLinkNode, null);
            myLinkNode.setPrev(curLinkNode);
            myLinkNode = curLinkNode;
        }
    }

    public void addLast(E e) {
        if (myLinkNode == null) {
            myLinkNode = new MyLinkNode<>(e);
        } else {
            MyLinkNode curLinkNode = new MyLinkNode(e, null, myLinkNode);
            myLinkNode.setNext(curLinkNode);
        }
    }

    /**
     * remove the first element
     */
    public E pop() {
        if (myLinkNode != null) {
            MyLinkNode head = myLinkNode;
            myLinkNode = myLinkNode.next;
            myLinkNode.setPrev(null);
            head.setNext(null);
            return (E) head.getValue();
        }
        return null;
    }

    /**
     * peek the first element,but don't remove elment
     *
     * @return
     */
    public E peek() {
        if (myLinkNode != null) return myLinkNode.getValue();
        return null;
    }

    @Test
    public void test() {
        MyDeque<Integer> myDeque = new MyDeque();
        myDeque.addFirst(1);
        myDeque.addFirst(2);
        Assert.assertTrue(Integer.valueOf(2).equals(myDeque.pop()));
        myDeque.addFirst(3);
        Assert.assertTrue(Integer.valueOf(3).equals(myDeque.pop()));
        myDeque.addLast(4);
        Assert.assertTrue(Integer.valueOf(1).equals(myDeque.pop()));
        myDeque.addFirst(5);
        Assert.assertTrue(Integer.valueOf(5).equals(myDeque.peek()));
    }

    private class MyLinkNode<E> {

        private E e;
        private MyLinkNode next;
        private MyLinkNode prev;

        public MyLinkNode(E e) {
            this.e = e;
        }

        public MyLinkNode(E e, MyLinkNode next, MyLinkNode prev) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }

        public MyLinkNode getNext() {
            return next;
        }

        public void setNext(MyLinkNode next) {
            this.next = next;
        }

        public MyLinkNode getPrev() {
            return prev;
        }

        public void setPrev(MyLinkNode prev) {
            this.prev = prev;
        }

        public E getValue() {
            return e;
        }

        public void setValue(E e) {
            this.e = e;
        }
    }

}
