package com.lga.bytedance;


/**
 * @Description: 单链表   增删改查
 * @Author:liugaoan
 * @Date: 2023/2/7
 */
public class SingleLinkedList {

    private SNode head = null;


    /**
     * 尾部添加
     * @param val
     */
    public void addTailNode(int val) {
        SNode p = new SNode(val, null);

        if (head == null) {
            head = p;
        } else {
            SNode q = head;
            while (q.next != null) {
                q = q.next;
            }
            q.next = p;
        }
    }

    /**
     * 头部添加节点
     * @param val
     */
    public void addHeadNode(int val) {
        SNode p = new SNode(val, null);

        if (head == null) {
            head = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public boolean deleteNode(int val) {

        if (head == null) {
            return false;
        } else {
            SNode p = head;
            SNode q = null;
            while (p != null && p.data != val) {
                q = p;
                p = p.next;
            }

            if (p == null) {
                return false;
            }

            if (q == null) {
                head = head.next;
            }else{
                q.next = q.next.next;
            }
        }


        return true;
    }




    public void printAll() {

        SNode p = head;
        while (p != null) {
            System.out.print(p.data + "-> ");
            p = p.next;
        }
    }


    public static void main(String[] args) {


        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addTailNode(1);
        singleLinkedList.addTailNode(2);
        singleLinkedList.addTailNode(3);
        singleLinkedList.addTailNode(4);
        singleLinkedList.addHeadNode(5);
        singleLinkedList.deleteNode(3);
        singleLinkedList.deleteNode(5);


        singleLinkedList.printAll();

    }





    private class SNode {

        private Integer data;

        private SNode next;

        public SNode(Integer data, SNode next) {
            this.data = data;
            this.next = next;
        }

        public Integer getData() {
            return data;
        }

        public SNode getNext() {
            return next;
        }


    }
}

