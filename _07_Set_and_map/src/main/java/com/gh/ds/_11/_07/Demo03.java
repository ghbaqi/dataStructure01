package com.gh.ds._11._07;

import com.gh.ds._11._07.set.LinkedListSet;

public class Demo03 {

    public static void main(String[] args) {

        LinkedListSet<String> set = new LinkedListSet<String>();

        set.add("abc");
        set.add("bc");
        set.add("c");
        set.add("d");
        set.add("bc");
        set.add("abcd");
        set.add("c");

        System.out.println(set.getSize());

        System.out.println(set.contains("a"));
        System.out.println(set.contains("abc"));

        set.remove("bc");
        System.out.println(set.contains("bc"));


    }
}
