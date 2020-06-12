package com.exampple.leetcode.middle;

// 三数之和

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution_0015 {

    /**
     * 先对数组排序
     * 外层循环 + 内层双指针
     * O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();

        int second;
        int third;

        // -4, -1, -1, 0, 1, 2
        // -4, -1, -1, 0, 1, 2
        int temp;
        for (int i = 0; i < nums.length - 2; i++) {   // 第一个 加数 在外层循环这里 取

            // 舍弃重复 的三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }


            second = i + 1;
            third = nums.length - 1;


            /**
             * 内层循环  使用双指针
             */
            while (second < third) {

                // 舍弃重复的  三元组
                if (second > i + 1 && nums[second] == nums[second - 1]) {
                    second++;
                    continue;
                }

                temp = nums[second] + nums[third];
                if (temp > -nums[i]) {
                    third--;
                } else if (temp < -nums[i]) {
                    second++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                    second++;
                }

            }

        }


        return res;
    }


    public static void main(String[] args) {

        Solution_0015 so = new Solution_0015();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {-4, -1, -1, 0, 1, 2};
//        int[] nums = {-1, -1, 2};
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> res = so.threeSum(nums);

        for (List<Integer> list : res) {
            System.out.println(list.get(0) + " , " + list.get(1) + " , " + list.get(2));
        }

    }

}
