package com.gh.ds._11._08;

import com.gh.ds._11._08.ds.MaxHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Demo01 {

    public static void main(String[] args) {


        MaxHeap<Integer> heap = new MaxHeap<Integer>();
        heap.add(5);
        heap.add(6);
        heap.add(4);
        heap.add(7);
        heap.add(3);
//        heap.print();

        System.out.println("max1 = " + heap.removeMax());
        heap.print();

        System.out.println("max2 = " + heap.removeMax());
        heap.print();

        System.out.println("max3 = " + heap.removeMax());
        heap.print();

        System.out.println("max4 = " + heap.removeMax());
        heap.print();

        System.out.println("max5 = " + heap.removeMax());
        heap.print();

        System.out.println("max6 = " + heap.removeMax());
        heap.print();


        /**
         * java.util.PriorityQueue
         * 可以传入自定义比较器 , 使得如何 定义优先级 更加灵活      ☆  ☆  ☆  ☆  ☆
         */
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();        // 此时的优先级为 : 字符串长度越小 , 优先级越高
            }
        });

    }


}
