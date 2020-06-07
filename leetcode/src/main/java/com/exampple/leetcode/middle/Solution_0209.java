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
public class Solution_0209 {

    /**
     * 解法一 : 暴力解法 , 暴力枚举子序列
     * <p>
     * 解法二 : 双指针  滑动窗口
     */
    public int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int sum = nums[0];

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;

        while (right < nums.length) {

            while (sum < s && right <= nums.length - 2) {
                right++;
                sum = sum + nums[right];
            }


            //
            while (sum >= s && left <= right) {
//                System.out.println("left = " + left + " , right = " + right + " . sum = " + sum);

                minLength = Math.min(minLength, right - left + 1);

                sum = sum - nums[left];
                left++;
            }

            if (right == nums.length - 1)
                break;

        }

        if (minLength == Integer.MAX_VALUE)
            return 0;

        return minLength;
    }

    public static void main(String[] args) {

        Solution_0209 so = new Solution_0209();
//        System.out.println(so.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(so.minSubArrayLen(7, new int[]{2, 4, 5, 1}));

    }
}
