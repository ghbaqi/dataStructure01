package com.exampple.leetcode.simple;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * -----------------------------------------
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Solution_0070 {

    /**
     * 要到达第 n 阶 , 有两种方式 : 从第 n-2 阶走两步  或者 n-1 阶走一步
     * 因此 f(n) = f(n-2) + f(n-1)
     */
    public int climbStairs(int n) {

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);

    }

    public int climbStairs_1(int n) {

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int i = 1;  // f(n-2)
        int j = 2;  // f(n-1)
        int res = 0;

        for (int k = 3; k <= n; k++) {
            res = i + j;
            i = j;
            j = res;
        }


        return res;
    }

    public static void main(String[] args) {

        Solution_0070 so = new Solution_0070();
        System.out.println(so.climbStairs_1(1));
        System.out.println(so.climbStairs_1(2));
        System.out.println(so.climbStairs_1(3));
        System.out.println(so.climbStairs_1(4));
        System.out.println(so.climbStairs_1(5));

    }
}
