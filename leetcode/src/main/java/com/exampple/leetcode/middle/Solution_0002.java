package com.exampple.leetcode.middle;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */

import java.util.List;
import java.util.Stack;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class Solution_0002 {


    /**
     * 单链表
     * 链表头部代表的是  低位
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(-11);
        ListNode cur = dummyHead;
        boolean flag = false;  // 是否有进位

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (flag)
                sum++;
            if (sum > 9) {
                cur.next = new ListNode(sum % 10);
                flag = true;
            } else {
                cur.next = new ListNode(sum);
                flag = false;
            }

            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        /**
         * 至此 , 有几种 case
         * 1 . 有进位 无进位
         * 2. 两个链表都为空
         * 3. 两个链表其中 一个不为空
         */

        if (l1 == null && l2 == null) {
            if (flag)
                cur.next = new ListNode(1);
        } else {
            l1 = l2 == null ? l1 : l2;
            while (l1 != null) {
                int val = l1.val;
                if (flag) {
                    val++;
                }
                if (val > 9) {
                    cur.next = new ListNode(val % 10);
                    flag = true;
                } else {
                    cur.next = new ListNode(val);
                    flag = false;
                }
                cur = cur.next;
                l1 = l1.next;

            }
        }

        if (flag)
            cur.next = new ListNode(1);

        return dummyHead.next;
    }


    public static void main(String[] args) {

        Solution_0002 so = new Solution_0002();

        // 342  + 465

        ListNode l1 = new ListNode(1);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(5);
        l1.next = n1;
        n1.next = n2;
        n2.next = n3;


        ListNode l2 = new ListNode(9);
        ListNode m1 = new ListNode(9);
        ListNode m2 = new ListNode(9);
        l2.next = m1;
        m1.next = m2;


        ListNode res = so.addTwoNumbers(l1, l2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
