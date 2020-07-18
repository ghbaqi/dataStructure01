package com.exampple.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

public class Solution_0001_2 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    /**
     *
     */
    public int[] twoSum(int[] nums, int target) {

        // value : index
        Map<Integer, Integer> map = new HashMap<>();

        Integer another;
        for (int i = 0; i < nums.length; i++) {

            another = map.get(target - nums[i]);  // 另一个 加数
            if (another == null) {   // 此时 没有找到 另一个加数
                map.put(nums[i], i);
            } else {
                return new int[]{another, i};
            }

        }

        return null;

    }

    public static void main(String[] args) {
        Solution_0001_2 s = new Solution_0001_2();
        int[] ints = {3, 5, 5, 8, 99, 3, 4, 5};
        int[] res = s.twoSum(ints, 10);
        for (int i : res) {
            System.out.println(i);
        }
    }


}
