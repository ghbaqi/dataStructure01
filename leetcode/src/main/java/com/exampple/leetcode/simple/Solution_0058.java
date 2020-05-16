package com.exampple.leetcode.simple;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 */
public class Solution_0058 {

    public int lengthOfLastWord(String s) {

        if (s == null || s.trim() == "")
            return 0;

        int blackIndex = -1;

        s = s.trim();
        // "Hello World"
        /**
         * 找到最后一个 " " 的位置
         */
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                blackIndex = i;
        }

        if (blackIndex == -1)
            return s.length();


        return s.length() - blackIndex - 1;
    }

    public static void main(String[] args) {
        Solution_0058 so = new Solution_0058();
        System.out.println(so.lengthOfLastWord(" a b cd  "));
    }
}
