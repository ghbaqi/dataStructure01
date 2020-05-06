package com.gh.ds._07.map;

public class Node<K extends Comparable, V> {

    protected Node left;
    protected Node right;

    protected K k;

    protected V v;

    protected Node(K k, V v) {
        this.k = k;
        this.v = v;
    }
}
