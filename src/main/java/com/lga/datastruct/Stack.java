package com.lga.datastruct;

public interface Stack <E>{

    /**
     * 栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * data元素入栈
     * @param data
     */
    void push(E data);

    /**
     * 返回栈顶元素,未出栈
     * @return
     */
    E peek();

    /**
     * 出栈,返回栈顶元素,同时从栈中移除该元素
     * @return
     */
    E pop();


    /**
     * 栈大小
     * @return
     */
    int size();



}
