package com.exampple.leetcode.simple;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */

import java.awt.*;

/**
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution_0066 {

    // [7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6]
    public int[] plusOne(int[] digits) {

        if (digits.length == 1) {
            digits[0] = digits[0] + 1;
        } else {
            // 从低位开始 加 1  ,  可能会有进位产生
            for (int i = digits.length - 1; i >= 0; i--) {

                // 最低位加 1
                if (i == digits.length - 1) {
                    digits[i] = digits[i] + 1;
                    if (digits[i] == 10) {
                        digits[i] = 0;
                        digits[i - 1] = digits[i - 1] + 1;
                    }
                } else if (i != 0) {
                    if (digits[i] == 10) {
                        digits[i] = 0;
                        digits[i - 1] = digits[i - 1] + 1;
                    }
                }

            }
        }


        if (digits[0] != 10)
            return digits;

        int[] res = new int[digits.length + 1];
        res[0] = 1;

        return res;
    }

    public static void main(String[] args) {
        Solution_0066 so = new Solution_0066();
//        int[] res = so.plusOne(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6});
        int[] res = so.plusOne(new int[]{9,9});
        for (int i : res) {
            System.out.println(i);
        }
    }
}
