package com.lga.source.analyze;

public class LinkedList<E> {

    private int size;

    private Node<E> first;

    private Node<E> last;

    /**
     * 添加一个元素到最后
     * @param e
     * @return
     */
    public boolean addLast(E e) {
        final Node<E> l = last;
        Node<E> newNode = new Node<>(l,e,null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * 插入一个元素到第一个位置
     * @param e
     * @return
     */
    public boolean addFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;

        if (f == null) {
            last = newNode;
        }else{
            f.prev = newNode;
        }
        size++;
        return true;
    }

    /**
     * 插入一个元素到指定索引位置
     * @param index
     * @param e
     * @return
     */
    public boolean add(int index, E e) {

        checkIndex(index);

        if (index == 0) {
            addFirst(e);
        }

        if (index + 1 == size) {
            addLast(e);
        }

        //查找当前位置的节点
        Node<E> node = getNode(index);
        Node<E> p = node.prev;

        final Node<E> newNode = new Node<>(p,e,node);
        p.next = newNode;
        node.prev = newNode;

        size++;
        return true;
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        checkIndex(index);
        return getNode(index).item;
    }

    private Node<E> getNode(int index) {
        Node<E> head = first;

        for (int i = 0; i < size; i++) {
            if (i == index) {
                return head;
            }
            head = head.next;
        }

        return null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index + 1 > size) {
            throw new IllegalArgumentException("index is Illegal");
        }
    }

    public void print() {
        Node<E> head = first;
        for (int i = 0; i < size; i++) {
            System.out.print(head.item + "->");
            head = head.next;
        }
        System.out.println();
        System.out.println("size = " + size);
    }

    /**
     * 存储元素的 数据结构
     * @param <E>
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("a");
        linkedList.addLast("b");
        linkedList.addLast("c");
        linkedList.addLast("d");
        linkedList.print();

        System.out.println();
        System.out.println("-----");

        linkedList.addFirst("1");
        linkedList.print();


        System.out.println();
        System.out.println("-----");

        linkedList.add(2, "3");
        linkedList.print();


        System.out.println();
        System.out.println("-----");

        String s = linkedList.get(2);
        System.out.println("s = " + s);

        String s1 = linkedList.get(10);
        System.out.println("s = " + s1);

    }
}
