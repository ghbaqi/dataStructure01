package com.exampple.leetcode.simple;


/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution_0027 {


    /**
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     */
    public int removeElement_1(int[] nums, int val) {

        /**
         * 1 2  4 2 5
         * 移除 2
         * 新数组 1  4  5  2 2
         */


        // 遍历数组 , 当遇到值为 val 的元素时 , 就与最后一个元素交换位置 , 维护 j 的值

        int count = 0;
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {


            // 遇到需要后移的元素时
            if (nums[i] == val) {

                // 拿到尾部元素 , 如果尾部元素也是待 移 元素 , 则 此时 j-- , 而 i 保持不动
                if (nums[j] == val) {
                    j--;
                    i--;
                } else {
                    // 尾部元素不是 val  时 , 将 i 处元素交换到最后 , j--  i++
                    count++;
                    swap(i, j, nums);
                    j--;
                }

            } else {
                // 计数
                count++;
            }

        }


//        System.out.println("count = " + count);
//        return -1;
        return count;
    }

    private void swap(int pre, int i, int[] nums) {

        int temp = nums[i];
        nums[i] = nums[pre];
        nums[pre] = temp;

    }


    // 1 2 3 2 5     2
    public int removeElement(int[] nums, int val) {

        // i 维护了值为 val  最前面的一个位置
        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            //
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }

        }

        return i;
    }


}
