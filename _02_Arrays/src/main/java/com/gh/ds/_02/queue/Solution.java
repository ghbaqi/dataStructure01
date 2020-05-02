package com.gh.ds._02.queue;

public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getKthMagicNumber(5));
        System.out.println(solution.getKthMagicNumber(8));
        System.out.println(solution.getKthMagicNumber(100));

        System.out.println("-------------------");

        System.out.println(solution.getKthMagicNumber(1));
        System.out.println(solution.getKthMagicNumber(2));
        System.out.println(solution.getKthMagicNumber(3));
        System.out.println(solution.getKthMagicNumber(4));
        System.out.println(solution.getKthMagicNumber(5));
        System.out.println(solution.getKthMagicNumber(6));
        /**
         * 9
         * 25
         * 33075
         */

    }

    /**
     * 3 ^a  * 5^b * 7^c
     * 找数值规律性题目 , 根据数值产生和分布的规律
     */
    public int getKthMagicNumber(int k) {

        int index3 = 0;
        int index5 = 0;
        int index7 = 0;

        int[] arr = new int[k];
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {

            /**
             * 后一个丑数一定是前面某个已求得的丑数 分别 * 3 5 7 , 取其中最小的
             * 并且前面的这个丑数 * 3 后 , 下次一定就不用再 * 3 了 , 就向下滚动
             */
            arr[i] = Math.min(arr[index3] * 3, Math.min(arr[index5] * 5, arr[index7] * 7));
            if (arr[i] == arr[index3] * 3) index3++;
            if (arr[i] == arr[index5] * 5) index5++;
            if (arr[i] == arr[index7] * 7) index7++;

        }


        return arr[k - 1];
    }

    /**
     * 1   1
     * 2  a =3
     * 3
     */

}












































