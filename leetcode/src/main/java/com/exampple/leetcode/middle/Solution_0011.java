package com.exampple.leetcode.middle;

/**
 * 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */

/**
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class Solution_0011 {

    /**
     * 面积 由  长度 * 高度 共同决定
     * <p>
     * 解法一 : 暴力解法 , O(n^2)
     */
    public int maxArea_1(int[] height) {

        int maxArea = 0;

        // i 左边 , j 右边
        int area;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = (j - i) * Math.min(height[i], height[j]);   // 宽度  *  高度(高度取 左右高 较小的)
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    /**
     * 时间复杂度：O(N)，双指针总计最多遍历整个数组一次。
     * <p>
     * 在相同情况下 , 两边距离越远越好
     * 区域受限于较短边
     */
    public int maxArea(int[] height) {

        int maxArea = 0;
        int area = 0;
        int left = 0;
        int right = height.length - 1;

        // 这个问题可以采用双指针 , 是在特定情况下问题的性质决定的
        while (left < right) {
            area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right]) {
                /**
                 * 为什么 左边界 < 右边界  , 就可以直接跳过当前值 , 当前 left 已经不可能和 其它 right  构成更大了
                 * 因为 : 再以这个  当前 left  为边时 , 矩形高度不变 (仍未当前 height[left])  , 而 宽度会变短
                 * 所以可以跳过当前这个 继续寻找
                 */
                left++;
            } else {
                right--;
            }
        }


        return maxArea;
    }

    public static void main(String[] args) {
        Solution_0011 so = new Solution_0011();
        /**
         * 当 2 和 最右边 1 构成一个矩形后  1 * 5 = 5
         * 2 左侧的 任何高 都不可能和 做右侧的 1  构成更大的矩形了 。 因为高度最多为 1 , 长度只会变短
         * 所以可以直接跳过 最右侧 1
         */
        System.out.println(so.maxArea(new int[]{2, 5, 100, 1, 1,1}));
    }
}
