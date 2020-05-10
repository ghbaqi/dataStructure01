package com.exampple.leetcode.simple;

import sun.tools.tree.BooleanExpression;

import javax.xml.soap.Node;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * <p>
 * 判断 t 是不是 s 的子树 , 只需要递归的判断 s 的左右孩子 是不是和 t  相等 || s 和 t  是不是相等
 */
public class Solution_0572 {


    /**
     *
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (t == null)
            return false;
        if (s == null)
            return false;

        /**
         * 递归算法 , 递归查看 根节点的 左右子树 是不是和 t 一样
         */
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 判断两棵树  是不是完全相同
     */
    public boolean isSameTree(TreeNode m, TreeNode n) {

        // 先判断根节点 是否相等
        if (m == null && n == null)
            return true;
        if (m == null && n != null)
            return false;
        if (m != null && n == null)
            return false;

        if (m.val != n.val)
            return false;

        // 再递归地查看 左右孩子是不是完全相等
        return isSameTree(m.left, n.left) && isSameTree(m.right, n.right);
    }


    public static void main(String[] args) {
        Solution_0572 so = new Solution_0572();
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2, new TreeNode(5), new TreeNode(6));

//        System.out.println(so.isSameTree(node.right, node.right));

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
