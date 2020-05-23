package com.gh.ds._11._06;

import com.gh.ds._11._06.ds.BST;

public class Demo02 {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<Integer>();

        bst.add(10);
        bst.add(15);
        bst.add(8);
        bst.add(20);
        bst.add(100);
        bst.add(13);

//        System.out.println(bst.remove(3));

        bst.remove(10);
        bst.inOrder();


    }
}
