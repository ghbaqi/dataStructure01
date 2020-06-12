package com.exampple.leetcode.simple;

// 二叉树的最小深度

import com.exampple.leetcode.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Solution_0111 {

    /**
     * 和求二叉树的高度是个 相反的过程
     * 以 root 为根的二叉树最小高度  =  1 + 左右子树较小的高度
     */
    public int minDepth(TreeNode root) {

        return getMinHeight(root);
    }

    // 获取以 node 为根的 二叉树的最小高度
    private int getMinHeight(TreeNode node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return 1 + 0;
        if (node.left == null)
            return 1 + getMinHeight(node.right);
        if (node.right == null)
            return 1 + getMinHeight(node.left);

        return 1 + Math.min(getMinHeight(node.left), getMinHeight(node.right));

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        TreeNode n1 = new TreeNode(2);

        node.right = n1;

        Solution_0111 so = new Solution_0111();
        System.out.println(so.getMinHeight(node));
    }
}
