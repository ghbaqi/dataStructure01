package com.exampple.leetcode.simple;

/**
 * @author : gaohui
 * @Date : 2020/7/12 20:33
 * @Description :  反转链表
 */


import com.exampple.leetcode.ListNode;

/**
 * 输入: 1->2->3->4->5->NULL
 * <p>
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution_0206 {

    /**
     * 使用 迭代 实现 , 复杂度 O(n)
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummyHead = new ListNode(-1);

        ListNode next = head;           // 只是作为向后 滚动的 指针
        ListNode cur;                   // 当前要链接的 节点  ， 往新链表上进行链接

        while (next != null) {
            cur = new ListNode(next.val);
            next = next.next;
            cur.next = dummyHead.next;
            dummyHead.next = cur;

        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        Solution_0206 so = new Solution_0206();
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;


        ListNode res = so.reverseList(head);
        res.print();

    }
}
