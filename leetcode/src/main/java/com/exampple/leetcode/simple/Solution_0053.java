package com.exampple.leetcode.simple;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 解法 1 遍历
 * O (n)
 * 最大值是  怎么样产生的  ? ?
 * <p>
 * 解法 1 遍历
 * O (n)
 * 最大值是  怎么样产生的  ? ?
 * <p>
 * 解法 1 遍历
 * O (n)
 * 最大值是  怎么样产生的  ? ?
 * <p>
 * 解法 1 遍历
 * O (n)
 * 最大值是  怎么样产生的  ? ?
 * <p>
 * 解法 1 遍历
 * O (n)
 * 最大值是  怎么样产生的  ? ?
 * <p>
 * 解法 1 遍历
 * O (n)
 * 最大值是  怎么样产生的  ? ?
 * <p>
 * 解法 1 遍历
 * O (n)
 * 最大值是  怎么样产生的  ? ?
 */

/**
 * 解法 1 遍历
 * O (n)
 * 最大值是  怎么样产生的  ? ?
 */

/**
 * 解法 2
 * 遍历数组 , 若前一个元素大于 0  , 将前一个元素加到后一个元素身上 ,
 * 遍历完成后 , 取出当前数组的最大值
 */
public class Solution_0053 {

    // 1 , -2, -5, 3, -3, 4,  ,-1, 5
    public int maxSubArray(int[] nums) {

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            max = Math.max(nums[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution_0053 so = new Solution_0053();
        System.out.println(so.maxSubArray(new int[]{-2, 1}));
    }

}
