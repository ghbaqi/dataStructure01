package com.exampple.leetcode.other;

/**
 * @author : gaohui
 * @Date : 2020/7/1 21:42
 * @Description :
 * <p>
 * 二分查找法
 */
public class BinearySearch02 {

    /**
     * 先从数据最中间查找 ，
     * 待查找元素 小于 中间元素 ， 从左边找
     * 待查找元素 大于 中间元素 ， 从右边找
     */
    public static int find(int target, int[] arr) {

        if (arr == null || arr.length == 0)
            return -1;

        int left = 0;
        int right = arr.length - 1;
        int mid;

        // 在数组的 [left , right] 闭区间内 查找 target
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 7, 9, 10};
        System.out.println(BinearySearch02.find(0, arr));
        System.out.println(BinearySearch02.find(3, arr));
        System.out.println(BinearySearch02.find(7, arr));
        System.out.println(BinearySearch02.find(10, arr));
        System.out.println(BinearySearch02.find(11, arr));
    }


}
