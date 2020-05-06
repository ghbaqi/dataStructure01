package com.gh.ds._07.map;

/**
 * 实现一个 链表
 * 1. 添加元素
 */

// TODO 使用递归实现对链表的 增删改查
public class LinkedList<K, V> {

    /**
     * 引入虚拟头结点 , 使链表头第一个元素 和其它元素处理逻辑一致
     */
    private Node dummyHead;

    private int size;


    public V removeElement(K k) {
        if (k == null)
            return null;
        Node pre = dummyHead;
        Node cur = pre.next;
        while (cur != null) {

            if (cur.k.equals(k)) {
                pre.next = cur.next;
                cur.next = null;
                size--;
                return (V) cur.v;
            } else {
                pre = cur;
                cur = cur.next;

            }

        }
        return null;

    }

    /**
     * 向链表头部 添加元素
     */
    public void addFirst(K k, V v) {

        Node node = new Node(k, v, dummyHead.next);
        dummyHead.next = node;
        size++;
    }


    /**
     *
     */
    public V get(K k) {

        if (k == null)
            return null;
        Node cur = dummyHead.next;
        while (cur != null) {
            if (k.equals(cur.k))
                return (V) cur.v;
            cur = cur.next;
        }
        return null;

    }


    public boolean contains(K k) {
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (k == null) {
                if (cur.k == null)
                    return true;
            } else {
                if (k.equals(cur.k))
                    return true;
            }
        }
        return false;
    }


    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void set(K k, V v) {
        if (k == null)
            throw new RuntimeException("key 不能为空");

        Node pre = dummyHead;
        Node cur = dummyHead.next;
        while (cur != null) {
            if (k.equals(cur.k)) {
                cur.v = v;
                return;
            }
            cur = cur.next;
        }
        addFirst(k, v);
    }

    private class Node<K, V> {

        public K k;
        public V v;

        public Node next;


        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public Node(K k, Node next) {
            this.k = k;
            this.next = next;
        }

        public Node(K k) {
            this.k = k;
        }

        public Node() {
        }
    }

}
