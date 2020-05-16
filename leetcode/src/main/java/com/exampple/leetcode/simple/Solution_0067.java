package com.exampple.leetcode.simple;

/**
 * 67. 二进制求和
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 */

/**
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
public class Solution_0067 {


    public String addBinary(String a, String b) {

        int maxLength = Math.max(a.length(), b.length());

        String res = "";

        // 先补齐位数 , 让长度短的  高位补 0
        if (a.length() < maxLength) {
            for (int i = (maxLength - a.length()); i > 0; i--) {
                a = "0" + a;
            }
        }
        if (b.length() < maxLength) {
            for (int i = (maxLength - b.length()); i > 0; i--) {
                b = "0" + b;
            }
        }


        // temp 存储对应位 之和
        int temp = 0;
        // 标记是否进位
        boolean flag = false;


        // a 11   ,  b 01
        // 从最低位开始 ,
        for (int i = maxLength - 1; i >= 0; i--) {


            // 取出两个串  对应位置相加
            temp += Integer.valueOf(a.charAt(i) + "");
            temp += Integer.valueOf(b.charAt(i) + "");

            // 判断之前是否有 进位
            if (flag) {
                temp += 1;
                flag = false;
            }

            // 根据不同的 temp  的大小 , 得出当前的位 大小  , 并修改 flag
            if (temp == 3) {
                flag = true;
                res = "1" + res;
                temp = 0;
            } else if (temp == 2) {
                res = "0" + res;        // 坑 ! 追加的顺序不能弄错
                flag = true;
                temp = 0;
            } else {
                res = temp + res;
                flag = false;
                temp = 0;
            }
        }

        if (flag)
            res = "1" + res;

        return res;
    }


    /**
     * 示例 1:
     * <p>
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     * <p>
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     */
    public static void main(String[] args) {
        Solution_0067 so = new Solution_0067();
        System.out.println(so.addBinary("0", "0"));

    }
}
