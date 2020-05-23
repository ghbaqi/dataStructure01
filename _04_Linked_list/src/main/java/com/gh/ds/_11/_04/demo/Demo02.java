package com.gh.ds._11._04.demo;

import com.gh.ds._11._04.myll.LinkedList;

public class Demo02 {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

//        list.add(2,1000);


        System.out.println(list.get(0)); // 5

        list.remove(0);
        System.out.println(list.get(0));  // 4


    }
}
