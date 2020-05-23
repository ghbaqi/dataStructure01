package com.gh.ds._11._07;

import com.gh.ds._11._07.set.BstSet;

public class Demo01 {

    public static void main(String[] args) {

        BstSet<String> set = new BstSet<String>();
        set.add("a");
        set.add("b");
        set.add("abc");
        set.add("a");
        set.add("g");
        set.add("b");
        set.add("ff");

        System.out.println(set.getSize());
        System.out.println(set.contains("ff"));
        System.out.println(set.contains("abcd"));
    }
}
