package com.exampple.leetcode.middle;

// 长度最小的子数组

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 */

/**
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class Solution_0209_2 {

    /**
     * 解法一 : 暴力解法 , 暴力枚举子序列
     * <p>
     * 解法二 : 双指针  滑动窗口
     */
    public int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        // [left , right]
        /**
         *
         */
        while (right <= nums.length - 1) {

            while (sum < s && right <= nums.length - 1) {
                sum += nums[right];
                right++;
            }

            while (left <= right && sum >= s) {
                //                minLength = Math.min(minLength, right - left + 1);
                minLength = Math.min(minLength, right - left);
                sum = sum - nums[left];
                left++;
            }

        }

        if (minLength == Integer.MAX_VALUE)
            return 0;


        return minLength;
    }

    public static void main(String[] args) {

        Solution_0209_2 so = new Solution_0209_2();
        //        System.out.println(so.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(so.minSubArrayLen(7, new int[]{2, 4, 5, 11}));

    }
}
