package com.exampple.leetcode.simple;

// 对称二叉树

import com.exampple.leetcode.TreeNode;

import java.util.ArrayList;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class Solution_0101 {

    /**
     * 解法一 : 层次遍历 , 判断每一层是否对称
     */
    public boolean isSymmetric_1(TreeNode root) {

        if (root == null)
            return true;

        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);

        TreeNode left;
        TreeNode right;

        while (!list.isEmpty()) {

            ArrayList<TreeNode> nextLevel = new ArrayList<>();

            int size = list.size();
            for (int i = 0; i < size; i++) {

                left = list.get(i);
                right = list.get(size - i - 1);

                if (left == null && right == null) {

                } else if (left == null && right != null) {
                    return false;
                } else if (left != null && right == null) {
                    return false;
                } else {
                    if (left.val != right.val) {
                        return false;
                    }
                    nextLevel.add(left.left);
                    nextLevel.add(left.right);
                }


            }

            list = nextLevel;

        }

        return list.isEmpty();
    }

    /**
     * 解法二  : 递归写法
     */
    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;
        return check(root.left, root.right);


    }

    private boolean check(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (p != null && q == null)
            return false;
        if (p == null && q != null)
            return false;
        if (p.val != q.val)
            return false;

        return check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
        Solution_0101 so = new Solution_0101();

        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);

        root.left = n1;
        root.right = n2;

        n1.right = n3;
        n2.right = n4;

        System.out.println(so.isSymmetric(root));


    }
}
