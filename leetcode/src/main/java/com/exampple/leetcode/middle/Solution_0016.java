package com.exampple.leetcode.middle;

//最接近的三数之和

import sun.security.provider.Sun;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * <p>
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Solution_0016 {

    /**
     * 从数组中  挑三个数 和与 target 最接近
     * <p>
     * 1 . 解法一 : 要想挑选 三个数 , 暴力枚举  三层 for 循环
     * 2 . 解法二 : 先排序  , 双指针
     */
    public int threeSumClosest(int[] nums, int target) {

        // 先排序
        Arrays.sort(nums);

        int pre;
        int next;

        int sum = nums[0] + nums[1] + nums[2];

        int currentSum;

        /**
         * 外层遍历数组 :
         * 拿到当前数字 , 取数组中最小的  + 当前 + 数组最大元素
         */
        for (int i = 1; i <= nums.length - 2; i++) {

            pre = 0;
            next = nums.length - 1;


            // 不会 漏掉一些情况吗 ?  ?
            while (pre < i && next > i) {                        // 利用了 排过序 之后的数据特征

                currentSum = nums[i] + nums[pre] + nums[next];
                if (currentSum > target) {    // 当前 和 大于 target  , 后指针前移
                    next--;
                } else if (currentSum < target) {   // 当前和 小 , 前指针后移
                    pre++;
                } else {
                    return currentSum;
                }

                if (Math.abs(currentSum - target) < Math.abs(sum - target)) {    // 寻找最接近  target 的三个数字和
                    sum = currentSum;
                } else {

                }

            }

        }

        return sum;
    }


    public static void main(String[] args) {
        Solution_0016 so = new Solution_0016();
        int i = so.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(i);
    }
}
