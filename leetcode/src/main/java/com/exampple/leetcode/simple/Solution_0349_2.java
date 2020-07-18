package com.exampple.leetcode.simple;

import java.util.HashSet;
import java.util.Iterator;

public class Solution_0349_2 {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        HashSet<Integer> join = new HashSet<>();

        for (int j : nums2) {
            if (set.contains(j))   // l两个数组的 公共元素  ， 即交集
                join.add(j);
        }

        int[] res = new int[join.size()];
        Iterator<Integer> iterator = join.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            res[index] = iterator.next();
            index++;
        }


        return res;
    }

}
