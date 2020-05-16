package com.exampple.leetcode.middle;

import sun.java2d.pipe.TextRenderer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class Solution_0102 {

    public List<List<Integer>> levelOrder_1(TreeNode root) {

//        if (root == null)
//            return null;

        ArrayList<List<Integer>> res = new ArrayList<>();

        ArrayList<List<TreeNode>> tempList = new ArrayList<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        if (root != null)
            nodes.add(root);
        tempList.add(nodes);


        for (int i = 0; i < tempList.size(); i++) {

            ArrayList<Integer> innerElements = new ArrayList<>();
            ArrayList<TreeNode> nextInnerNodes = new ArrayList<>();

            List<TreeNode> innerNodes = tempList.get(i);
            for (TreeNode node : innerNodes) {

                innerElements.add(node.val);
                if (node.left != null) {
                    nextInnerNodes.add(node.left);
                }
                if (node.right != null) {
                    nextInnerNodes.add(node.right);
                }

            }

            if (innerElements.size() > 0)
                res.add(innerElements);
            if (nextInnerNodes.size() > 0)
                tempList.add(nextInnerNodes);


        }


        return res;
    }


    /**
     * 引入一个 分解符   来区别 层级
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
//            res.add(new ArrayList<>());
            return res;
        }


        LinkedList<TreeNode> tempNodes = new LinkedList<>();
        tempNodes.addFirst(root);

        TreeNode cur;

        int currentLevelSize;
        while (!tempNodes.isEmpty()) {

            // 第一次进入时 , 记录这层的元素个数
            currentLevelSize = tempNodes.size();

            // 把这一层的元素全过一遍
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < currentLevelSize; i++) {
                cur = tempNodes.removeLast();
                nums.add(cur.val);
                if (cur.left != null)
                    tempNodes.addFirst(cur.left);
                if (cur.right != null)
                    tempNodes.addFirst(cur.right);
            }

            res.add(nums);

        }


        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param args
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

        Solution_0102 so = new Solution_0102();
        List<List<Integer>> res = so.levelOrder(root);
        for (List<Integer> list : res) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
            System.out.println(" ++++++++++++++++++++++");
        }


    }

}
