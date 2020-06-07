package com.exampple.leetcode.simple;

import java.util.Stack;

// TODO
public class BstWhileLook {


    /**
     * 非 递归 中序遍历  二叉树
     * <p>
     * <p>
     * 左孩子  根   右孩子
     */
    private void look(TreeNode node) {

        TreeNode cur = node;

        TreeNode root;
        TreeNode left;
        TreeNode right;


        Stack<TreeNode> stack = new Stack<>();

        while (cur != null) {

        }


    }


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
