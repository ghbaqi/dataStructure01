package com.exampple.leetcode.simple;

// 平衡二叉树

import com.exampple.leetcode.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class Solution_0110 {

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        // 采用 层次遍历  , 因为不平衡节点 更有可能出现在  最上层 , 这样当 不平衡时 ,  可以较快的 判断出来
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(root);
        int size;

        TreeNode node;
        while (!list.isEmpty()) {
            size = list.size();
            for (int i = 0; i < size; i++) {
                node = list.removeLast();
                if (node.left != null)
                    list.addFirst(node.left);
                if (node.right != null)
                    list.addFirst(node.right);
                if (Math.abs(getHeight(node.left) - getHeight(node.right)) >= 2)
                    return false;
            }
        }


        return true;
    }

    /**
     * 获取以 node 为根 的二叉树的高度
     */
    private int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }


}
