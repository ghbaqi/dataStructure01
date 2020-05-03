package com.gh.ds._04.demo;


import java.util.LinkedList;

/**
 * 链表 : 真正的动态数据结构 , 也是较为简单的动态数据结构
 *
 * <p>
 * 单链表
 * 双链表
 */
public class Demo01 {

    public static void main(String[] args) {


        /**
         * java 的双链表 : java.util.LinkedList
         *
         */

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(2, 1000);


        System.out.println(list.getFirst());
        System.out.println(list.getLast());

//        System.out.println(list.get(2));

        list.remove();   // 移除的 head 位置元素

        System.out.println(list.getFirst());
        System.out.println(list.getLast());


    }
}
