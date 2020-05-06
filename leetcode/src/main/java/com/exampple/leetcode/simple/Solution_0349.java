package com.exampple.leetcode.simple;

import java.util.HashSet;

// 给定两个数组，编写一个函数来计算它们的交集。

public class Solution_0349 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set01 = new HashSet<Integer>();
        for (int i : nums1) {
            set01.add(i);
        }

        HashSet<Integer> set02 = new HashSet<Integer>();
        for (int i : nums2) {
            if (set01.contains(i))
                set02.add(i);
        }

        int[] arr = new int[set02.size()];
        int j = 0;
        for (Integer i : set02) {
            arr[j] = i;
            j++;
        }

        return arr;
    }

}
