package com.exampple.leetcode.simple;

import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class Solution_0104 {

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        int depth = 0;
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.addFirst(root);

        int size;
        TreeNode last;

        while (!list.isEmpty()) {

            depth++;
            size = list.size();
            for (int i = 0; i < size; i++) {
                last = list.removeLast();
                if (last.left != null)
                    list.addFirst(last.left);
                if (last.right != null)
                    list.addFirst(last.right);

            }

        }
        return depth;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
