package com.exampple.leetcode.other;

/**
 * 在有序数组中 , 进行二分查找
 */
public class BinearySearchInArray {

    public int search(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int mid;

//        while (left <= right - 2) {
        while (left <= right) {

            mid = left + (right - left) / 2;

            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }

        }

//        if (arr[left] == target)
//            return left;
//        if (arr[right] == target)
//            return right;

        return -1;
    }

    public static void main(String[] args) {
        BinearySearchInArray b = new BinearySearchInArray();
        System.out.println(b.search(new int[]{3, 7, 8, 9, 10, 11, 18}, 33));
    }

}
