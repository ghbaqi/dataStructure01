package com.exampple.leetcode.simple;

/**
 * @author : gaohui
 * @Date : 2020/7/5 11:15
 * @Description :
 * <p>
 * 存在重复元素 II
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class Solution_0219 {

    // 找两个 距离比较近的 相同元素
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length <= 1)
            return false;

        // K : V   元素值 : 索引位置
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                int exitIndex = map.get(nums[i]);
                if (i - exitIndex <= k)
                    return true;
                map.put(nums[i], i);   // 已经存在相同的值 ， 但是距离不符合 ， 重置这个值的 index ， 进行下次的比较
            } else {
                map.put(nums[i], i);
            }

        }


        return false;
    }

    public static void main(String[] args) {

        Solution_0219 so = new Solution_0219();
        int[] arr = {1, 2, 3, 1, 2, 3};
        System.out.println(so.containsNearbyDuplicate(arr, 5));

    }
}
