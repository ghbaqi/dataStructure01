package com.exampple.leetcode.simple;

// 移动零

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class Solution_0283 {

    public void moveZeroes(int[] nums) {

        int temp;

        // 外层 遍历数组
        for (int i = 0; i < nums.length; i++) {

            // 遇到 0 元素时
            if (nums[i] == 0) {
                // 往后 找 第一个 不是 0  的元素 , 替换过来
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;            // 从 0 元素后面找第一个 非 0 元素 , 替换过来
                    }
                }
            }

        }


    }

    public static void main(String[] args) {
        Solution_0283 so = new Solution_0283();
        int[] arr = {0, 1, 0, 3, 12};
        so.moveZeroes(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
