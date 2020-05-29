package com.exampple.leetcode.middle;

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
public class Solution_0003 {

    /**
     * 无重复 最长子串
     */
    // 解法二  : 滑动窗口及优化
    public int lengthOfLongestSubstring(String s) {

        if (s == null)
            return 0;

        HashSet<Character> set = new HashSet<>();

        // 记录最大长度
        int max = 0;

        // 记录每次 子串的 长度
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            // 如果子串中已经包含当前这个字符 , 需要重新开始计数
            if (set.contains(c)) {
//                length = 1;
                set.clear();
//                set.add(c);

                // 先把  i  指针需要  回溯回去  , 再  length = 0 ;
                i = i - length + 1 - 1;
                length = 0;


            } else {
                // 子串中不包含当前字符  , 加入 set
                set.add(c);
                length++;
            }

            // 记录最大值
            max = Math.max(max, length);

        }

        return max;
    }

    /**
     * 0   1   2     3
     * d   v   d     f
     */
    public static void main(String[] args) {
        Solution_0003 so = new Solution_0003();
        System.out.println(so.lengthOfLongestSubstring("abcadfadad"));

        // 优化 , 当指针来到 i=3 时 , 此时 我们知道  0-3 这个区间是有重复字符的  , 下次可以跳过这段 , 直接让 i =  4 开始重新计
    }
}
