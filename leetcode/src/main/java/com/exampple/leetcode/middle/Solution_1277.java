package com.exampple.leetcode.middle;

/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class Solution_1277 {

    public int countSquares(int[][] matrix) {


        int count = 0;

        // 外层数组长度是 行数 , 内层数组长度是 列数
        int[] row;

        // 1. 遍历整个 矩阵 , 拿到每个元素
        for (int i = 0; i < matrix.length; i++) {
            row = matrix[i];                        // 代表第 i  行

            for (int j = 0; j < row.length; j++) {
                // 2 .  拿到当前元素  matrix[i][j] , 统计以当前元素为 左上顶点 的正方形个数
                count += getSquare(i, j, matrix);

            }

        }


        return count;
    }


    // 2 . 拿到当前元素  matrix[i][j] , 统计以当前元素为 左上顶点 的正方形个数
    private int getSquare(int i, int j, int[][] matrix) {
        int count = 0;

        // 3. 以  matrix[i][j] 为左上顶点的正方形  的最大宽度
        int maxWidth = Math.min(matrix.length - i, matrix[i].length - j);

        // 4. 查看所有可能存在的 正方形 , 宽度从  1 --> maxWidth
        flag:
        for (int k = 1; k <= maxWidth; k++) {

            // 里面还需要一个双层  for 循环 , 判断以  matrix[i][j] 为顶点 , width = k  区域内的所有元素是否全部为 1
            for (int m = i; m < i + k; m++) {
                for (int n = j; n < j + k; n++) {
                    if (matrix[m][n] != 1) {
                        break flag;
                    }
                }

            }
            count++;
        }


        return count;
    }

    public static void main(String[] args) {

        flag:
        for (int i = 0; i < 10; i++) {

            System.out.println(" i = " + i);

            for (int j = 0; j < 5; j++) {
                if (j == 3) {
                    break flag;
                } else {
                    System.out.println("i = " + i + " , j = " + j);
                }
            }
        }

    }

}
