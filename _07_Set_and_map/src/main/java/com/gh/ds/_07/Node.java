package com.gh.ds._07;

public class Node<E extends Comparable> {

    protected Node left;
    protected Node right;

    protected E e;

    protected Node(E e) {
        this.e = e;
    }
}
