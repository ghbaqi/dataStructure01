package com.gh.ds._11._07.set;

import com.gh.ds._11._07.LinkedList;

/**
 * 基于链表实现 集合
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        this.list = new LinkedList<E>();
    }

    public void add(E e) {
        if (!list.contains(e))
            list.addFirst(e);
    }

    public void remove(E e) {
        list.removeElement(e);
    }

    public int getSize() {
        return list.getSize();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }
}
