package com.gh.ds._12.ds;

public class Node<E extends Comparable> {

    protected Node left;
    protected Node right;

    protected int h = 1;

    protected E e;

    protected Node(E e) {
        this.e = e;
    }
}
