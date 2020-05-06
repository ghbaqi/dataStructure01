package com.exampple.leetcode.simple;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 350. 两个数组的交集 II
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 */
public class Solution_0350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();


        // 第一个的数组 放入 map  中
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        // 将重复元素及 个数 存入这个 map 中
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

        // 记录数组中元素总数 , 方便对数组初始化
        int count = 0;

        for (int i : nums2) {

            // 公共元素 , 放入 map2 , 且保证重复元素个数 是此元素 在两个数组中出现少的那个次数
            if (map.containsKey(i)) {
                if (map2.get(i) == null) {
                    map2.put(i, 1);
                    count++;
                } else {
                    // 保证重复元素 是 两个 数组中少的  那个计数
                    if (map2.get(i) < map.get(i)) {
                        map2.put(i, map2.get(i) + 1);
                        count++;
                    }
                }
            }
        }


        int[] arr = new int[count];

        count = 0;

        // 遍历 map2 , 对数组赋值
        for (Integer k : map2.keySet()) {
            for (Integer i = 0; i < map2.get(k); i++) {
                arr[count] = k;
                count++;
            }
        }


        return arr;
    }

    public static void main(String[] args) {
        Solution_0350 so = new Solution_0350();
        int[] arr1 = new int[]{4, 9, 5};
        int[] arr2 = new int[]{9, 4, 9, 8, 4};
        int[] res = so.intersect(arr1, arr2);
        for (int i : res) {
            System.out.println(i);
        }

    }
}
