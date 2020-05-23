package com.gh.ds._11._10;


import com.gh.ds._11._10.ds.Trie;

public class Demo01 {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.put("a");
        trie.put("bb");
        trie.put("abc");
        trie.put("bb");

//        System.out.println(trie.getSize());

//        System.out.println(trie.contains("a"));
//        System.out.println(trie.contains("bb"));
//        System.out.println(trie.contains("abc"));
//
//        System.out.println(trie.contains("b"));
//        System.out.println(trie.contains("c"));
//        System.out.println(trie.contains("ab"));

        System.out.println(trie.startsWith("a"));
        System.out.println(trie.startsWith("b"));
        System.out.println(trie.startsWith("ab"));

        System.out.println(trie.startsWith("c"));
        System.out.println(trie.startsWith("bbc"));
        System.out.println(trie.startsWith("ac"));

    }
}
