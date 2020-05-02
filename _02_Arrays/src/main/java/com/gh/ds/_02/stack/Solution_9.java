package com.gh.ds._02.stack;

public class Solution_9 {


    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 1. 使用 string 反转  , 看值是否相等
     * 2. 使用栈
     */
    public boolean isPalindrome(int x) {


        if (x < 0)
            return false;

        StringBuffer sb = new StringBuffer();
        sb.append(x);
        Long x1 = Long.valueOf(sb.reverse().toString());   // 倒过来可能会有溢出 ?

        return x1.intValue() == x;
    }

    public static void main(String[] args) {
        Solution_9 solution9 = new Solution_9();

        System.out.println(solution9.isPalindrome(1));
        System.out.println(solution9.isPalindrome(12));
        System.out.println(solution9.isPalindrome(123));
        System.out.println(solution9.isPalindrome(1221));
        System.out.println(solution9.isPalindrome(2147483647));
    }
}
