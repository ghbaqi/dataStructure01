package com.exampple.leetcode.simple;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 */

/**
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Solution_0028 {

    public int strStr(String haystack, String needle) {

        if (haystack == null)
            return -1;
        if (needle == null || needle.equals(""))
            return 0;

        int index = -1;

        // 外循环 , 遍历父串 , 看以父串开头的各个元素后面的若干元素  是否与子串 相同
        flag:
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {


            // 内循环 , 子串 挨个与父串比较 , 偏移量为 i
            for (int j = 0; j < needle.length(); j++) {


                if (haystack.charAt(j + i) == needle.charAt(j)) {
                    // 当比较到最后一位  ,  即可跳出外循环 , 此时已经找到
                    if (j == needle.length() - 1) {
                        index = i;
                        break flag;
                    }
                } else {
                    // 有一位 没有对应上 , 既跳出内循环
                    break;
                }

            }
        }


        return index;
    }

    public static void main(String[] args) {
        Solution_0028 so = new Solution_0028();
        System.out.println(so.strStr("ababdfffgg", "ab"));
    }
}
