package com.gh.ds._11._04.myll;

// 可以采用增加一个虚拟头结点的方式 , 给 head 节点增加一个前驱节点 , 简化逻辑
public class Solution_0203 {

    // 删除链表中等于给定值 val 的所有节点。
    // 5 2 4 5 6 8 1 1 7
    public ListNode removeElements(ListNode head, int val) {


        ListNode cur = head;

        // 要删除一个节点 , 必须记住它的前驱节点
        ListNode pre = null;

        /**
         * 要删除一个节点 , 需要记住 它的前驱节点
         */
        // 当前节点 , 依次判断链表中所有节点, 向后滚动
        while (cur != null) {


            if (cur.val == val) {

                // 头结点
                if (pre == null) {
                    head = head.next;
//                    pre = cur;
                    cur = cur.next;
                    // 非头结点
                } else {
                    pre.next = cur.next;
                    cur = cur.next;

                }

                // 不需要删除 , 向后滚动
            } else {
                pre = cur;
                cur = cur.next;
            }


        }
        return head;
    }

    /**
     * 递归解决此问题
     * = head + removeElements_2(ListNode head.next)
     * 最小的问题 : head == null  return null
     * 怎么化解  : head.next
     */
    public ListNode removeElements_2(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode rest = removeElements_2(head.next, val);

        if (head.val == val) {
            head.next = null;
            return rest;
        } else {
            head.next = rest;
            return head;
        }

    }


    public static void main(String[] args) {
        Solution_0203 so = new Solution_0203();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);

        ListNode res = so.removeElements(head, 1);
        System.out.println("111");
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
