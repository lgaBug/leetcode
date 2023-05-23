package com.lga.bytedance;

public class LRUList {


    private Integer capacity;

    // 带头节点的链表
    private Node head = new Node(-1, null);


    public LRUList(Integer capacity) {
        this.capacity = capacity;
    }


    public int length() {
        int len = 0;
        Node p = head;

        while (p.next != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    private void addFirst(Node node) {
        Node p = head;
        Node next = p.next;
        node.next = next;
        p.next = node;
    }

    public void add(Integer val) {

        Node p = head;
        //1.当val是存在于缓存中
        while (p.next != null) {
            if (p.next.val == val) {
                //1.1 将p节点放到头节点
                Node cur = p.next;
                p.next = p.next.next;
                addFirst(cur);
                return;
            }
            p = p.next;
        }

        // 2.1 判断是否缓存是否已满
        if (length() == capacity) {
            //2.1.1删除尾节点
            deleteLastNode();
        }
        //2.2放入头节点
        addFirst(new Node(val, null));

    }

    private void deleteLastNode() {

        if (length() == 0) {
            return;
        }

        Node p = head;
        //定位到尾节点的前一个节点
        while (p.next.next != null) {
            p = p.next;
        }

        //删除尾节点
        p.next = p.next.next;
    }

    public void printNode() {
        Node p = head.next;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }


    public static void main(String[] args) {


        LRUList lruList = new LRUList(10);

        lruList.add(1);
        lruList.add(2);
        lruList.add(3);
        lruList.add(4);
        lruList.add(5);
        lruList.add(6);
        lruList.add(7);
        lruList.add(8);
        lruList.add(9);
        lruList.add(10);
        lruList.add(11);



        lruList.printNode();
    }


    public class Node {

        private Integer val;

        private Node next;

        public Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }
    }




}
