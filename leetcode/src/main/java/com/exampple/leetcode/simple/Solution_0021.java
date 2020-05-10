package com.exampple.leetcode.simple;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution_0021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /**
         * 使用一个新链表 挨个追加元素
         */
        ListNode dummyNode = new ListNode(-1);

        ListNode pre = dummyNode;

        // 两个链表都不为空时
        while (l1 != null && l2 != null) {

            /**
             * 比较两个链表中元素大小 , 挨个放到新链表尾部
             * 每次只加一个元素 , 每次也只有一个链表向后滚动
             */
            if (l1.val <= l2.val) {
                ListNode node = new ListNode(l1.val);
                pre.next = node;
                pre = node;
                l1 = l1.next;

            } else if (l2.val <= l1.val) {
                ListNode node = new ListNode(l2.val);
                pre.next = node;
                pre = node;
                l2 = l2.next;
            }
        }

        // 其中一个为空 , 直接放到新链表尾部
        if (l1 != null) {
            pre.next = l1;
        } else {
            pre.next = l2;
        }

        return dummyNode.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println(00);
        Solution_0021 so = new Solution_0021();
        ListNode l1 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        l1.next = n1;
        n1.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        l2.next = n2;
        n2.next = new ListNode(4);

        ListNode res = so.mergeTwoLists(l1, l2);
        System.out.println();

        // 1 1 3 4 2 4
    }

}
