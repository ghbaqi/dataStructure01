package com.gh.ds._10.ds;

import java.util.*;

/**
 * 自定义 Trie
 * 专门用于 字符串 的 高效查询
 */
public class Trie {

    private class Node {

        public boolean isWord;
        public Map<Character, Node> next;

        public Node() {
            next = new HashMap<Character, Node>();
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<Character, Node>();
        }
    }

    private int size;

    private Node root;

    public Trie() {
        root = new Node();
    }

    public int getSize() {
        return size;
    }

    public void put(String word) {
        if (word == null || word.trim().equals(""))
            return;
        Node pre = root;
        Node cur;

        for (int i = 0; i < word.length(); i++) {

            cur = pre.next.get(word.charAt(i));
            if (cur == null) {
                cur = new Node();
                pre.next.put(word.charAt(i), cur);
            } else {

            }

            // 来到了单词的最后一个字符
            if (i == word.length() - 1) {
                // 可能当前添加的节点 已经存在了
                if (!cur.isWord) {
                    cur.isWord = true;
                    size++;
                }
            }
            pre = cur;
        }
    }

    public boolean contains(String word) {

        if (word == null || word.trim().equals(""))
            return false;

        Node pre = root;
        Node cur;
        for (int i = 0; i < word.length(); i++) {
            cur = pre.next.get(word.charAt(i));
            if (cur == null)
                return false;
            if (i == word.length() - 1) {
                return cur.isWord;
            }
            pre = cur;
        }

        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     * 查看是否有 以给定前缀结尾的单词
     */
    public boolean startsWith(String prefix) {

        if (prefix == null || prefix.trim().equals(""))
            return false;
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            cur = cur.next.get(prefix.charAt(i));
            if (cur == null)
                return false;
        }

        return true;
    }

}
