package com.lga.algorithm.tag.homework.Week_01;

/**
 * 641. 设计循环双端队列
 * <p>
 * https://leetcode-cn.com/problems/design-circular-deque/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 */
public class MyCircularDeque {

    private int capacity;
    private int[] arrs;

    /**
     * Current myCircularDeque size
     */
    private int size;

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k;
        arrs = new int[capacity];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (!isFull()) {
            System.arraycopy(arrs, 0, arrs, 1, size);
            this.arrs[0] = value;
            size++;
            return true;
        }
        return false;

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (!isFull()) {
            this.arrs[size++] = value;
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (!isEmpty()) {
            System.arraycopy(arrs, 1, arrs, 0, --size);
            return true;
        }
        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (!isEmpty()) {
            arrs[--size] = 0;
            return true;
        }
        return false;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return isEmpty()?-1:arrs[0];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return isEmpty()?-1:arrs[size - 1];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return getCapacity() == getSize();
    }

    public static void main(String[] args) {
//        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
//        Assert.assertTrue(circularDeque.insertLast(1));                    // 返回 true
//        Assert.assertTrue(circularDeque.insertLast(2));                    // 返回 true
//        Assert.assertTrue(circularDeque.insertFront(3));                    // 返回 true
//        Assert.assertFalse(circularDeque.insertFront(4));                    // 已经满了，返回 false
//        Assert.assertTrue(2 == circularDeque.getRear());                // 返回 2
//        Assert.assertTrue(circularDeque.isFull());                        // 返回 true
//        Assert.assertTrue(circularDeque.deleteLast());                    // 返回 true
//        Assert.assertTrue(circularDeque.insertFront(4));                    // 返回 true
//        Assert.assertTrue(4 == circularDeque.getFront());                // 返回 4

//        MyCircularDeque circularDeque = new MyCircularDeque(4);
//        Assert.assertTrue(circularDeque.insertFront(9));
//        Assert.assertTrue(circularDeque.deleteLast());
//        Assert.assertTrue(circularDeque.getRear());
//        Assert.assertTrue(circularDeque.getFront());
//        Assert.assertTrue(circularDeque.getFront());
//        Assert.assertTrue(circularDeque.deleteFront());
//        Assert.assertTrue(circularDeque.insertFront());
//        Assert.assertTrue(circularDeque.insertFront());
//        Assert.assertTrue(circularDeque.insertFront());
//        Assert.assertTrue(circularDeque.getFront());
//        Assert.assertTrue(circularDeque.insertFront());


    }

}
