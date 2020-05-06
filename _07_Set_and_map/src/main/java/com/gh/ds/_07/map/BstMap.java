package com.gh.ds._07.map;


/**
 * 基于 BST 实现 Map
 */
public class BstMap<K extends Comparable, V> implements Map<K, V> {

    private BST<K, V> bst;

    public BstMap() {
        bst = new BST();
    }

    public void add(K k, V v) {
        bst.add(k, v);
    }

    public boolean contains(K k) {
        return bst.contains(k);
    }

    public V remove(K k) {
        return bst.remove(k);
    }

    public void set(K k, V v) {
        bst.set(k, v);
    }

    public V get(K k) {
        return bst.get(k);
    }

    public int getSize() {
        return bst.getSize();
    }

    public boolean isEmpty() {
        return bst.getSize() == 0;
    }
}
