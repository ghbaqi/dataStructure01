package com.exampple.leetcode.simple;

public class RecrusiveSum {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 1, 2, 2, 2, 10, 10, 10};
        int s = sum(arr);
        System.out.println(s);
    }

    /**
     * sum arr =  arr[length-1] +  sum (0 ,  arr length - 2  )
     *
     * sum arr length-2 = arr[length-2] + sum ( 0 , arr length -3 )
     */
    public static int sum(int[] arr) {

        return m(arr, 0);
    }

    private static int m(int[] arr, int start) {

        if (start == arr.length) {
            return 0;
        }

        return arr[start] + m(arr, start + 1);
    }

}
