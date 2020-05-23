package com.gh.ds._11._07.map;


/**
 * 基于链表实现 Map  结构   < K V >
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private LinkedList<K, V> list;

    public LinkedListMap() {
        list = new LinkedList<K, V>();
    }

    public void add(K k, V v) {
        if (!contains(k))
            list.addFirst(k, v);
    }

    public boolean contains(K k) {
        return list.contains(k);
    }

    public V remove(K k) {
        return list.removeElement(k);
    }

    public void set(K k, V v) {
        list.set(k, v);
    }

    public V get(K k) {
        return list.get(k);
    }

    public int getSize() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }
}
