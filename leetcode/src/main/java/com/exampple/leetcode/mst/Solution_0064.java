package com.exampple.leetcode.mst;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution_0064 {

    /**
     * 等差数列 求和 ? ?
     */
    public int sumNums(int n) {


        return n == 0 ? 0 : n + sumNums(n - 1);
    }


    public static void main(String[] args) {
        Solution_0064 so = new Solution_0064();

        System.out.println(so.sumNums(2));
    }


}
