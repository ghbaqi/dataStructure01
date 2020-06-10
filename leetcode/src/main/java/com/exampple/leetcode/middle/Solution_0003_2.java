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
public class Solution_0003_2 {

    /**
     * 双指针 + hashset
     * 复杂度   O (n)
     */
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;

        c:
        while (right < s.length()) {

            /**
             * 右指针
             *
             */
            while (!set.contains(s.charAt(right))) {   // 当右边元素 不是重复元素时 , 加入 set
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(set.size(), maxLength);

                if (right == s.length())        // 到了末尾了   就不用管了 , 因为此时 肯定已经找到了 最长无重复子串了
                    break c;
            }


            // abca
            // 此时 right 所在 char 是重复元素

            /**
             * 左指针
             * 三种重复情况 :
             *
             * abc  a
             * bca  a
             * bacd a
             */


            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));          // 从左边开始 一直进行移除, 直到不包含  right 位置的  char
                left++;
            }


        }


        return maxLength;
    }


    public static void main(String[] args) {
        Solution_0003_2 so = new Solution_0003_2();
        System.out.println(so.lengthOfLongestSubstring("aaad"));

    }
}
