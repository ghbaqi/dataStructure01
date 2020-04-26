package com.gh.ds._02.stack;

import java.util.ArrayDeque;

public class Demo01 {

    /**
     * ArrayDeque 可以作为一种 Stack  的数据结构来使用
     * Stack   :  push   pop   peek
     */
    public static void main(String[] args) {

        ArrayDeque<String> deque = new ArrayDeque<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");


        // 看一眼 栈顶元素
        System.out.println(deque.peek());

        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
    }
}
