package com.exampple.leetcode;

/**
 * @author : gaohui
 * @Date : 2020/7/12 20:35
 * @Description :
 */
public class ListNode {

    public int      val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print() {
        if (this == null)
            System.out.println("null list node");
        ListNode cur = this;

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

    }
}
