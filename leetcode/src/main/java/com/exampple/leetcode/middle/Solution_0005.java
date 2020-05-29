package com.exampple.leetcode.middle;

// 最长回文子串

import java.util.jar.JarEntry;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 输入: "babadcc"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution_0005 {

    /**
     *
     */
    public String longestPalindrome_1(String s) {

        if (s.length() == 1 || s.equals(""))
            return s;

        int max = 0;

        boolean flag = false;

        String res = "";


        // 1 . 外层遍历 整个串
        for (int i = 0; i < s.length() && s.length() - i >= res.length(); i++) {  // 剩余长度 >= 已经找到的回文串长度

            // 2. 从尾部遍历  , 当内层字符 和 外层字符相同时 , 进入判断这个区间内的串  是不是回文的
            c:
            for (int j = s.length() - 1; j > i; j--) {

                // 此时 在 i --->  j 的区间可能是回文串
                if (s.charAt(i) == s.charAt(j)) {
                    int total = i + j;

                    // k 只需判断到 i --> j 之间一半的位置就行了
                    for (int k = i; k <= total / 2; k++) {
                        if (s.charAt(k) != s.charAt(total - k)) {
                            break;
                        }


                        if (k == total / 2) {
                            flag = true;   // 此时  i-->j 是回文串
                        }
                    }

                    // 此时 是对称的
                    if (flag) {
                        if (j - i + 1 > max) {              // 更新回文串
                            res = s.substring(i, j + 1);
                            max = j - i + 1;
                        }

                        flag = false;
                        break c;      // 在 j  较大时 , 已经找到一个回文串 ,  j 就不需要再往前遍历了  j--

                    }


                }


            }


        }

        if (res.equals(""))
            return s.substring(0, 1);

        return res;
    }

    /**
     * 采用动态规划来做
     * 状态方程 : dp[i , j] = s(i)==s(j)  && dp[i+1][j-1]   ,  i--j 之间的串是否回文 ,  由该串的 首尾字符是否相等 && 去掉首位之后是否回文  来共同决定
     * <p>
     * 当 j-i <= 2 时 , 是最小子问题 , 直接判断 得出是否回文
     * 当 j-i >= 3 时 , 进入状态方程
     */
    public String longestPalindrome(String s) {

        if (s.length() == 1 || s.equals(""))
            return s;

        int start = 0;
        int end = 0;

        char[] chars = s.toCharArray();

        boolean[][] dp = new boolean[s.length()][s.length()];

//        for (int i = 0; i < s.length(); i++) {
//            dp[i][i] = true;
//        }


        /**
         * 状态方程 : dp[i , j] = s(i)==s(j)  && dp[i+1][j-1]
         *
         *注意状态转移的顺序
         */

        // 先计算 列 小的
        for (int j = 1; j < s.length(); j++) {   // 列 递增

            // 先计算 行大的  i <=  j
            for (int i = j; i >= 0; i--) {    // 行 递减

                // 串长度较小时  , 直接判断
                if (j - i <= 2) {
                    if (chars[i] == chars[j]) {
                        dp[i][j] = true;
                        if (j - i > end - start) {
                            start = i;
                            end = j;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    // 长串  ,  进入状态转移方程
                    dp[i][j] = chars[i] == chars[j] && dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        if (j - i > end - start) {
                            start = i;
                            end = j;
                        }
                    }
                }

            }


        }


        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        Solution_0005 so = new Solution_0005();
        System.out.println(so.longestPalindrome("cbbd"));
    }
}
