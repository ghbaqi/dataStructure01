package com.gh.ds._11._07.set;

import com.gh.ds._11._07.BST;

/**
 * 集合 : 不存储重复数据的容器
 *
 * 基于 二分搜索树 实现集合
 */
public class BstSet<E extends Comparable> implements Set<E> {

    private BST<E> bst;


    public BstSet() {
        bst = new BST<E>();
    }

    public void add(E e) {
        bst.add(e);
    }

    public void remove(E e) {
        bst.remove(e);
    }

    public int getSize() {
        return bst.getSize();
    }

    public boolean contains(E e) {
        return bst.contains(e);
    }

    public boolean isEmpty() {
        return bst.getSize() == 0;
    }
}
