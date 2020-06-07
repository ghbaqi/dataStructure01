package com.exampple.leetcode.sort;

public class QuickSort {

    private void quickSort(int[] arr) {
        quickSortHelp(arr, 0, arr.length - 1);
    }

    private void quickSortHelp(int[] arr, int left, int right) {

        if (left < right) {
            int hole = adjustArray(arr, left, right);
            quickSortHelp(arr, left, hole - 1);
            quickSortHelp(arr, hole + 1, right);
        }

    }

    /**
     * 对数组进行整理
     * 移动 arr[0] 的位置  ,  使得  arr[0] 前面的都比它小  , 后面的都比它大
     */

    /**
     * 挖坑 + 交替填坑
     *
     * <p>
     * 对数组 arr 在  left  ---> right 范围内 进行整理
     * 使得 arr[left] 处于一个 分界位置 ,  它前面的元素都比它小 , 它后面的元素都比它大
     * <p>
     * 返回 初始 arr[left] 所在的 新位置
     */
    private int adjustArray(int[] arr, int left, int right) {

        int temp = arr[left];       // 用一个 临时变量  记住 当前 坑 的元素值
        int hole = left;            // 初始化 坑位
        int i = left;              // i ++ 从前往后 找 大的 元素
        int j = right;             // j -- 从后往前找 小的 元素

        while (i < j) {

            // j 从后面找 较小的 元素  ,  往前 填坑
            while (j > i) {
                if (arr[j] < temp) {
                    arr[hole] = arr[j];
                    hole = j;            // 更新 坑 的位置
                    break;
                }
                j--;
            }

            // 从前面找 较大的元素  , 往后 填坑
            while (i < j) {
                if (arr[i] > temp) {
                    arr[hole] = arr[i];
                    hole = i;
                    break;
                }
                i++;
            }

        }

        arr[hole] = temp;    // 填坑
        return hole;

    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
//        int[] arr = new int[]{72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        int[] arr = new int[]{96};
        quickSort.quickSort(arr);

        System.out.println("+++++             ++++++++");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void main_1(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
//        int[] arr = new int[]{72, 99};
        int hole = quickSort.adjustArray(arr, 0, arr.length - 1);
        System.out.println("hole = " + hole);

        System.out.println("+++++             ++++++++");
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
