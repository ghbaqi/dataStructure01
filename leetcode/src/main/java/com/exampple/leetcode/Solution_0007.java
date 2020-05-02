package com.exampple.leetcode;

public class Solution_0007 {

    // 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

    /**
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     * <p>
     * -130    -31
     * <p>
     * 溢出的情况如何考虑 ?
     */

    public int reverse_1(int x) {

        // 先去掉末尾的 0   , 110
        while (x % 10 == 0) {
            x = x / 10;
        }

        Long res;    //  先用 Long 类型接收 , 如果有溢出 , 则返回 0
        StringBuffer sb = new StringBuffer();

        // 对于 < 0 和 > 0 分别处理
        if (x < 0) {
            sb.append(Math.abs(x)).reverse();
            res = 0 - Long.valueOf(sb.toString());

            if (res < Integer.MIN_VALUE) {
                return 0;
            } else {
                return res.intValue();
            }

        } else {
            sb.append(x).reverse();
            res = Long.valueOf(sb.toString());
            if (res > Integer.MAX_VALUE) {
                return 0;
            } else {
                return res.intValue();
            }


        }

    }

    public int reverse(int x) {

        long a = Long.valueOf(x);
        long b;
        String s = "";

        b = x % 10;
        // 以  0 为结尾
        boolean f = b == 0 ? true : false;


        while (Math.abs(a) >= 10) {
            b = a % 10;
            a = a / 10;
//            if (f && b == 0) {
//                // 末尾的 0 舍弃
//            }

            // 当末尾是 0  ,且第一次遇到不是 0  的
            if (f && b != 0) {
                f = false;
            }
            if (!f) {
                // 末尾没有 0  ,  或者 0 已经全部去掉了
                s = s + Math.abs(b);
            }

        }

        s = s + Math.abs(a);
        Long res;
        if (x < 0) {
            res = Long.valueOf("-" + s);
        } else {
            res = Long.valueOf(s);
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE)
            return 0;

        return res.intValue();

    }

    public int reverse_3(int x) {
        long temp = 0;

        while (x != 0) {
            int pop = x % 10;
            temp = temp * 10 + pop;

            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) temp;
    }


    public static void main(String[] args) {
        Solution_0007 so = new Solution_0007();

        System.out.println(so.reverse_3(-10012000));
    }
}
