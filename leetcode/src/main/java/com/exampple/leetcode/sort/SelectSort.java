package com.exampple.leetcode.sort;

public class SelectSort {





    /**
     * 选择排序
     */
    public static void sort(int[] arr) {


        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ arr[j];
                }
            }

        }


    }

    public static void main(String[] args) {
        int[] arr = {3, 11, 0, 1, 13, 7, 99};
        SelectSort.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
