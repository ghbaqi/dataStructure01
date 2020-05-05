package com.exampple.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

// 144. 二叉树的前序遍历
public class Solution_0144 {


    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        preOrder(root, list);

        return list;
    }

    private void preOrder(TreeNode root, ArrayList<Integer> list) {
        list.add(root.val);
        if (root.left != null)
            preOrder(root.left, list);
        if (root.right != null)
            preOrder(root.right, list);
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
