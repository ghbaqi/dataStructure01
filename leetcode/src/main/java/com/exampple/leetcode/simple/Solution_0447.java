package com.exampple.leetcode.simple;

/**
 * @author : gaohui
 * @Date : 2020/7/5 10:47
 * @Description :
 * <p>
 * 回旋镖的数量
 */

import java.util.HashMap;

/**
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
 * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 */
public class Solution_0447 {

    public int numberOfBoomerangs(int[][] points) {

        if (points == null || points.length <= 2)
            return 0;
        int count = 0;


        HashMap<Integer, Integer> map = new HashMap<>();
        int[] centerPoint;
        for (int i = 0; i < points.length; i++) {
            centerPoint = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                int dis = getDistence(centerPoint, points[j]);
                if (map.get(dis) == null) {
                    map.put(dis, 1);
                } else {
                    map.put(dis, map.get(dis) + 1);
                }
            }

            for (Integer dis : map.keySet()) {
                count += map.get(dis) * (map.get(dis) - 1);
            }
            map.clear();
        }


        return count;
    }

    private int getDistence(int[] centerPoint, int[] point) {
        return (centerPoint[0] - point[0]) * (centerPoint[0] - point[0]) + (centerPoint[1] - point[1]) * (centerPoint[1] - point[1]);
    }
}
