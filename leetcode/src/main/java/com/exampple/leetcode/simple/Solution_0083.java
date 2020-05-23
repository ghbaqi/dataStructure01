package com.exampple.leetcode.simple;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 输入: 1->1->1->2
 * 输出: 1->2
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class Solution_0083 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
//                cur = cur.next;       // 相等时 , 指针不能向后移动
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        Solution_0083 so = new Solution_0083();
        ListNode head = new ListNode(1);

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;

        ListNode res = so.deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
