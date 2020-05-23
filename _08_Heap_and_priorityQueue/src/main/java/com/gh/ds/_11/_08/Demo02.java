package com.gh.ds._11._08;

import com.gh.ds._11._08.ds.MaxHeap;

import java.util.ArrayList;

public class Demo02 {

    public static void main(String[] args) {

        MaxHeap<Integer> heap = new MaxHeap<Integer>();

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(1);
        list.add(7);
        heap.heapify(list);

        heap.print();

    }
}
