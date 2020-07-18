package com.exampple.leetcode.simple;

/**
 * @author : gaohui
 * @Date : 2020/7/12 21:21
 * @Description :删除链表中等于给定值 val 的所有节点。
 */

import com.exampple.leetcode.ListNode;

/**
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Solution_0203 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = head;


        ListNode newNext = dummyHead;

        while (cur != null) {

            if (cur.val == val) {
            } else {
                newNext.next = new ListNode(cur.val);
                newNext = newNext.next;
            }

            cur = cur.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution_0203 so = new Solution_0203();
        ListNode head = new ListNode(6);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(6);
        ListNode n3 = new ListNode(6);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;

        so.removeElements(head, 6).print();
    }
}
