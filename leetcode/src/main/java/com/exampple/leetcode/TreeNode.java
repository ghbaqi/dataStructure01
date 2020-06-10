package com.exampple.leetcode;


public class TreeNode {

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


    public void inOrder() {
        inOrder(this);
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        if (node.left != null)
            inOrder(node.left);
        System.out.println(node.val);
        if (node.right != null)
            inOrder(node.right);
    }
}
