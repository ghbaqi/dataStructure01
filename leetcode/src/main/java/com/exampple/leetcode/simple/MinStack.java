package com.exampple.leetcode.simple;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> s1;

    private Stack<Integer> s2;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty()) {
            s2.push(x);
        } else {
            if (x <= s2.peek()) {
                s2.push(x);
            }
        }
    }

    public void pop() {
        Integer cur = s1.pop();


        if (!s2.isEmpty()) {
            if (cur == s2.peek())
                s2.pop();
        }

    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.pop();
    }

}
