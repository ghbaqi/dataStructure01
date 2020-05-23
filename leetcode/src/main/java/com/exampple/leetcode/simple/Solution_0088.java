package com.exampple.leetcode.simple;

/**
 * 合并两个有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */

/**
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Solution_0088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

//        if (m == 0 && n == 1) {
//            nums1[0] = nums2[0];
//            return;
//        }


        /**
         * 使用三个 指针  ,因为已经排序了 , 从尾部向前面遍历
         */
        int i = m - 1;
        int j = n - 1;

        for (int k = (m + n - 1); k >= 0; k--) {

            // 当第二个数组元素已经选完 , 或者第一个数组的元素 >= 第二个数组的元素  , 挑选第一个数组元素作为新数组的元素


            if (i >= 0 && (j < 0 || nums1[i] >= nums2[j])) {
                nums1[k] = nums1[i];
                i--;   // 移动指针
                // 第一个数组元素选完  或者  第二个数组元素  > 第一个数组元素
            } else if (j >= 0 && (i < 0 || nums1[i] < nums2[j])) {
                nums1[k] = nums2[j];
                j--;
            }
        }

//        for (int y : nums1) {
//            System.out.println(y);
//        }

    }

    public static void main(String[] args) {
        Solution_0088 so = new Solution_0088();
        so.merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }

}
