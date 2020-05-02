package com.exampple.leetcode;

import java.util.HashMap;

public class Solution_0001 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    public int[] twoSum(int[] nums, int target) {

        // 将一个数 拆成 两个数的 和
        /**
         *  3 5 1 9 33 2 66 88 4 6 7
         *
         *  10
         *
         */

        // key 数值  , value 在 nums  中的索引
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        Integer otherIndex;

        for (int i = 0; i < nums.length; i++) {

            otherIndex = map.get(target - nums[i]);
            if (otherIndex != null) {
                return new int[]{i, otherIndex};
            } else {
                map.put(nums[i], i);
            }

        }
        return null;

    }

    public static void main(String[] args) {
        Solution_0001 s = new Solution_0001();
        int[] ints = {3, 5, 2, 8, 99, 3, 4, 5};
        int[] res = s.twoSum(ints, 9);
        for (int i : res) {
            System.out.println(i);
        }
    }


}
