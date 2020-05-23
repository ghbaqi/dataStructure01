package com.gh.ds._11._07.map;

public interface Map<K, V> {

    void add(K k, V v);

    boolean contains(K k);

    V remove(K k);

    void set(K k, V v);

    V get(K k);

    int getSize();

    boolean isEmpty();

}
