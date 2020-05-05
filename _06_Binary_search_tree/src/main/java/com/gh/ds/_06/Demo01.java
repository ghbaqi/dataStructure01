package com.gh.ds._06;

import com.gh.ds._06.ds.BST;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Demo01 {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<Integer>();
        bst.add(10);
//        System.out.println(bst.getSize());

        bst.add(15);
        bst.add(8);
        bst.add(20);
        bst.add(100);
        bst.add(13);

//        bst.preOrder();

//        bst.inOrder();

//        bst.levelOrder_1();

//        bst.levelOrder_2();


        BST<Integer> bst02 = new BST<Integer>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            bst02.add(random.nextInt(100000));
        }


        System.out.println("size1 = " + bst02.getSize());

        ArrayList<Integer> list = new ArrayList<Integer>();
        while (bst02.getSize() > 0) {
            list.add(bst02.removeMin());
        }

        int pre = -1000;
        for (Integer i : list) {
            System.out.println(i);
            if (i <= pre) {
                throw new RuntimeException("pre = " + pre + " , i = " + i);
            }
            pre = i;
        }

        System.out.println("size2 = " + bst02.getSize());


    }

}
