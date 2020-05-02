package com.exampple.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Solution_0014 {

    // 1 . 暴力求解法
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        String min = strs[0];

        // 先找出 长度最小的 串
        for (String str : strs) {
            if (str.length() < min.length())
                min = str;
        }


        // 拿着最小串 和 数组 中每个串 挨个比较 , 更新最小串

        for (String str : strs) {

            for (int i = 0; i < min.length(); i++) {

                if (min.charAt(i) != str.charAt(i)) {
                    min = min.substring(0, i);
                    break;
                }
            }

        }


        return min;
    }

    public static void main(String[] args) {

        Solution_0014 so = new Solution_0014();

        String[] arr = new String[]{"abflower", "abflow", "abflight"};
        System.out.println(so.longestCommonPrefix(arr));
    }

    //  1.输入1234 输出 1243，从新排列，找出比1234大的第一个数。再比如1324 输出，1342
    /**
     * 123400   124300
     * 1222   2122
     * 1111   1111
     * 10     10
     * 54321  54321
     *
     *   从尾部开始遍历 , 栈存储
     *   栈不为空 且 栈顶元素比当前元素大 , 调换这  两个数字的位置
     *
     *   0 0 4 3
     *   0 0 3 4 2 1
     */


}
