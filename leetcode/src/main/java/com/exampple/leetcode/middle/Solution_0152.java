package com.exampple.leetcode.middle;

// 乘积最大子数组

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Solution_0152 {

    public int maxProduct_1(int[] nums) {

        int max = nums[0];
        int temp = 1;

        for (int i : nums) {

            temp = temp * i;


            /**
             * 理解错误 , 当 temp < 1 , 不能认为 i 对结果没有增益  ( -4 , -5 )
             * 当 temp > 1 , 也不能认为 i  对结果就有增益
             *
             * 这里和连续最大子数组和 还是有区别的   ! !
             */
            if (temp < 1) {
                max = Math.max(max, temp);
                temp = 1;
            } else {
                max = Math.max(max, temp);
            }

        }


        return max;
    }

    public int maxProduct_2(int[] nums) {

        int max = nums[0];
        int temp = 1;

        for (int i = 0; i < nums.length; i++) {

            temp = temp * nums[i];

            /**
             * 理解错误 , 当 temp < 1 , 不能认为 i 对结果没有增益  ( -4 , -5 )
             * 当 temp > 1 , 也不能认为 i  对结果就有增益
             *
             * 这里和连续最大子数组和 还是有区别的   ! !
             *
             * -4 , -5  , -1 , 7  , -9  3  .....   , 已经不能根据当前累乘 的结果判断 当前的元素是否 对结果 增益
             */
            if (temp < 1) {
                max = Math.max(max, temp);
                temp = 1;
            } else {
                max = Math.max(max, temp);
            }

        }


        return max;


    }

    /**
     * 动态规划 :  如何规划 ?  ?
     * <p>
     * 不能在 符号 上面 考虑了
     */
    public int maxProduct(int[] nums) {


        return -1;
    }

    public static void main(String[] args) {
        Solution_0152 so = new Solution_0152();
        System.out.println(so.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(so.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(so.maxProduct(new int[]{-2, -1, 0}));
        System.out.println(so.maxProduct(new int[]{0, -4, -3, 1, -2, 1, -3, 0, 11}));   // 72
    }
}
