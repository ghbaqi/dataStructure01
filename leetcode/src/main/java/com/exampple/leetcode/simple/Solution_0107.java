package com.exampple.leetcode.simple;

// 二叉树的层次遍历 II

import com.exampple.leetcode.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class Solution_0107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {


//        int depth = getDepth(root);
        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < depth; i++) {
//            res.add(null);
//        }

//        depth--;

        if (root==null){
            return res;
        }



        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root);

        int curDepthLength;
        while (!linkedList.isEmpty()) {

            curDepthLength = linkedList.size();   // 当前层 节点 个数
            List<Integer> levelList = new ArrayList<>(curDepthLength);

            for (int i = 0; i < curDepthLength; i++) {
                TreeNode node = linkedList.removeLast();
                levelList.add(node.val);
                if (node.left != null)
                    linkedList.addFirst(node.left);
                if (node.right != null)
                    linkedList.addFirst(node.right);
            }

            res.add(levelList);

        }

        Collections.reverse(res);

        return res;
    }


    /**
     * 获取 树 高度
     */
    private int getDepth(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(6);

        root.left = n1;

//        n1.right = n2;
//
//        n2.left = n3;
//        n3.right = n4;

        Solution_0107 so = new Solution_0107();
        List<List<Integer>> lists = so.levelOrderBottom(root);
        for (int i = 0; i < lists.size(); i++) {
            for (Integer j : lists.get(i)) {
                System.out.println(j);
            }
            System.out.println("level  = " + i);
        }

//        ArrayList<Integer> list = new ArrayList<>(2);
//        list.add(1, 10);
//        System.out.println(list.get(2));
    }
}
