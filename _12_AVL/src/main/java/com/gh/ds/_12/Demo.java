package com.gh.ds._12;

import com.gh.ds._12.ds.AVL;

import java.util.Random;

public class Demo {

    public static void main(String[] args) {

        AVL<Integer> avl = new AVL<Integer>();


//        avl.add(15);
//        avl.add(20);
//        avl.add(18);
//        avl.add(11);
//        avl.add(21);
//        avl.add(4);
//        avl.add(5);


        System.out.println(avl.isBalance());

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int j = random.nextInt(100);
            System.out.println(j);
            avl.add(j);
            System.out.println(avl.isBalance());
        }


    }
}
