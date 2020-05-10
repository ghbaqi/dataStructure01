package com.exampple.leetcode.simple;

import java.math.BigDecimal;

public class Solution_0069 {

    /**
     * 实现 int sqrt(int x) 函数。
     * <p>
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 101  ---> 10
     * 50  25     12  ( 10 )   6
     */

    // 最大为  46340
    public int mySqrt_1(int x) {
        if (x < 2)
            return x;
        if (x == 2 || x == 3)
            return 1;


        int big = x;         // 有坑
        int mid = x >> 1;

        // 先使用 逼近 , 确定结果上 上下边界  mid  < res <  big
        BigDecimal sqrt;

        while (true) {
            sqrt = new BigDecimal(mid).multiply(new BigDecimal(mid));
            if (sqrt.compareTo(new BigDecimal(x)) == 0) {
                return mid;
            } else if (sqrt.compareTo(new BigDecimal(x)) > 0) {
                big = mid;                                      // 先把此时 大的前边界记住
                mid = mid >> 1;
            } else {
                // 此时 mid*mid < x
                // 第一次出现了 , 平方小于当前数的数字  mid
                break;
            }
        }

        // 在 mid   和 big  之间 , 继续逼近
        for (int i = mid; i <= big; i++) {
            sqrt = new BigDecimal(i).multiply(new BigDecimal(i));
            if (sqrt.compareTo(new BigDecimal(x)) > 0) {
                return --i;
            } else if (sqrt.compareTo(new BigDecimal(x)) == 0) {
                return i;
            }

        }

        return -1;
    }

    // 125  60  30 15 7
    // 7 8 9 10  11      12

    // 46340

    public static void main(String[] args) {
        Solution_0069 so = new Solution_0069();

//        System.out.println(so.mySqrt(2147395599));
        System.out.println(so.mySqrt_1(2147483647));


    }


    public int mySqrt(int x) {


        return -1;
    }

}
