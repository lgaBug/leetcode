package com.lga;

import javax.xml.crypto.Data;

public class LinkedList {
    private Node head;

    private int size;

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();

        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        System.out.println("size=" + linkedList.size());
        linkedList.print();

        linkedList.delete(3);
        linkedList.print();

        linkedList.update(4,400);
        linkedList.print();




    }


    public LinkedList() {
    }

    public void print() {
        Node curNode = head;
        while (head != null) {
            System.out.println(head.data + "->");
            curNode = curNode.next;
        }
    }


    public int size() {
        Node curNode = head;
        int size = 0;
        while (head != null) {
            curNode = curNode.next;
            size++;
        }
        return size;
    }


    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {

            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }


    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node pre = head;
        Node curr = head.next;

        //筛选节点
        while (curr != null && curr.data != data) {
            pre = curr;
            curr = curr.next;
        }

        if (curr != null) {
            pre.next = curr.next;
        }
    }

    public void update(int oldData, int newData) {
        Node curr = head;

        //查找要更新的节点
        Node oldNode = find(oldData);
        if (oldNode != null) {
            oldNode.data = newData;
        }
    }


    public Node find(int data) {
        Node curr = head;
        while (curr != null && curr.data != data) {
            curr = curr.next;
        }
        return curr;
    }


    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }


}
