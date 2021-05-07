package com.lga.datastruct;

public class SeqStack<E> implements Stack<E>{

    /**
     * 栈顶位置
     */
    private int top = -1;


    private E[] data;


    private int capacity;


    public SeqStack(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(E e) {
        if (top + 1 >= capacity) {
            throw new IllegalArgumentException("栈满了，无法添加元素");
        }
        data[++top] = e;
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return data[top];
        }
        return null;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            return data[top--];
        }
        return null;
    }

    @Override
    public int size() {
        return top+1;
    }

    public static void main(String[] args) {
        SeqStack<Integer> stack = new SeqStack<>(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.size());


    }
}
