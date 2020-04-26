package com.gh.ds._02.stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class Demo01 {

    /**
     * java.util.Stack
     *
     * <p>
     * ArrayDeque 可以作为一种 Stack  的数据结构来使用
     * Stack   :  push   pop   peek
     * <p>
     * 是一种操作受限的线性结构 , 可以基于数组或者链表来进行实现
     */
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        stack.push(0);
        stack.push(5);
        stack.push(4);
        stack.push(1);

        System.out.println(stack.size());

        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.size());

    }
}
