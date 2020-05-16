package com.exampple.leetcode.simple;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 */
public class Solution_0035 {


    public int searchInsert(int[] nums, int target) {

        if (target < nums[0])
            return 0;
        if (target > nums[nums.length - 1])
            return nums.length;
//        int small;
//        int big;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target > nums[i]) {
//                small = i;
            } else {        // 第一次数组中 元素 大于 target
//                big = i;
                return i;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Solution_0035 so = new Solution_0035();

        System.out.println(so.searchInsert(new int[]{2, 4, 5, 7, 9}, 1));   // 0
        System.out.println(so.searchInsert(new int[]{2, 4, 5, 7, 9}, 4));  // 1
        System.out.println(so.searchInsert(new int[]{2, 4, 5, 7, 9}, 6));  // 3
        System.out.println(so.searchInsert(new int[]{2, 4, 5, 7, 9}, 8));  // 4
        System.out.println(so.searchInsert(new int[]{2, 4, 5, 7, 9}, 9));  // 4
        System.out.println(so.searchInsert(new int[]{2, 4, 5, 7, 9}, 10));  // 5
    }


}
