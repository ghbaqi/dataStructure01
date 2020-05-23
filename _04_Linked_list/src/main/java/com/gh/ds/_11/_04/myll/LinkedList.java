package com.gh.ds._11._04.myll;

/**
 * 实现一个 链表
 * 1. 添加元素
 */

// TODO 使用递归实现对链表的 增删改查
public class LinkedList<E> {

    /**
     * 引入虚拟头结点 , 使链表头第一个元素 和其它元素处理逻辑一致
     */
    private Node dummyHead;

    private int size;


    /**
     * 向链表头部 添加元素
     */
    public void addFirst(E e) {
        Node node = new Node(e, dummyHead.next);
        dummyHead.next = node;
        size++;
    }

    /**
     * 往链表尾部 添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向链表 索引为 index 位置添加元素
     */
    public void add(int index, E e) {

        // 当 index = size , 相当于向 链表尾部 添加元素 , 新添加的元素成为了 新的 尾部
        if (index < 0 || index > size)
            throw new RuntimeException("illegal index exception");

        // 先找到 index-1 位置的元素
        // 0 1 2 3
        // a b c d
//        if (index == 0) {
//            addFirst(e);
//            return;
//        }

        /**
         * eg : 我们想往 索引 = 3 的位置添加元素
         * 需要先找到 index = 2 位置的元素
         * i = 1 , i <= 2
         * i = 1   , 1
         * i = 2   , 2
         *
         * 如果我们要往 索引为 i 的位置添加元素 , 我们需要先找到 索引为 i-1 位置的元素
         */

        // dh  0 1 2 3
        //     a b c d
        Node preNode = dummyHead;
        for (int i = 1; i <= index; i++) {
            preNode = preNode.next;
        }

        Node newNode = new Node(e);
        newNode.next = preNode.next;
        preNode.next = newNode;
        size++;


    }

    /**
     *
     */
    public E get(int index) {

        if (index < 0 || index > size - 1)
            throw new RuntimeException("illegal index");
        Node cur = dummyHead.next;
        for (int i = 0; i <= index - 1; i++) {
            cur = cur.next;
        }
        return cur.e;

    }


    public boolean contains(E e) {
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
            if (e == null) {
                if (cur.e == null)
                    return true;
            } else {
                if (e.equals(cur.e))
                    return true;
            }
        }
        return false;
    }

    public void update(int index, E e) {

        if (index < 0 || index > size - 1)
            throw new RuntimeException("ilegal index");

        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;

    }

    /**
     * 删除 第 index 位置的元素
     */
    public E remove(int index) {

        if (index < 0 || index > size - 1)
            throw new RuntimeException("ilegal index");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++)
            pre = pre.next;

        Node cur = pre.next;
        pre.next = cur.next;
        cur.next = null;
        size--;
        return cur.e;
    }


    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
        }
    }

}
