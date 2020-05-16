package com.exampple.leetcode.simple;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class Solution_0136 {

    public int singleNumber(int[] nums) {

        int res = 0;
        for (int i : nums) {
            res = res ^ i;
        }


        return res;
    }

    public static void main_(String[] args) {

        Solution_0136 so = new Solution_0136();
        System.out.println(so.singleNumber(new int[]{1, 1, 2}));

    }

    public static void main(String[] args) {

        int a = 123;
        int b = 345;

        /**
         * 位运算 : 且  或 非  异或
         *
         * 异或 : 同一个位置上 , 相同为 0  , 不同为 1
         * 异或满足 交换律和结合律
         */

        // 使用位运算 , 交换两个数的值  ;
        a = a ^ b;
        b = a ^ b;  // a^b^b
        a = a ^ b;  // a^b   ^ a


        // 此时 b = 123 ;
        System.out.println(a ^ b ^ a);


        System.out.println("任何数与自身 异或  , 结果为 0");
        System.out.println(11 ^ 11);
        System.out.println(-10 ^ -10);


        System.out.println("任何数 与 0  异或 , 结果仍然为其自身");
        System.out.println(0 ^ 10);
        System.out.println(0 ^ -11);
        System.out.println(0 ^ 11123);
        System.out.println(0 ^ -11123);


    }

}
