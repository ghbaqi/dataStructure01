package com.exampple.leetcode.middle;

import apple.laf.JRSUIUtils;
import com.sun.tools.javac.util.RichDiagnosticFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class Solution_0236 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 即求出的结果节点 与  p  q 仍然构成一棵树
     *
     * 如何判断 一个节点  是不是另一个节点的祖先 ?
     */
    //

    /**
     * 如果从节点 x 经过深度优先遍历  可以到达  p  和 q  , 那么 x 就是 p q 的祖先 ,
     * 再继续看 x 的左右孩子是不是 p  q 的祖先 , 向下寻找最近的祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        // 层次遍历整棵树 , 挨个查看每个节点  是否为  p  q  的祖先   ( 由于是层次遍历 , 如果上层都不是 那么就不用再往下看了  )
        // 如果是 ,继续向下层遍历 , 直到找到最近的祖先

        TreeNode accestor = null;

        ArrayList<LinkedList<TreeNode>> list = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        list.add(nodes);

        /**
         * 由于是层次遍历 , 逐层向下 才能找到 最近的祖先
         * 优化 : 利用层次遍历  , 当上层都 不是祖先 就不用再向下层遍历了
         *
         * 如何知道 哪些是属于同一层的 ? ?  , 怎么知道我下次循环时 是进入到下一层了 ? ?    , 只有利用两层集合 才能知道何时 进入到下一层了
         */
        for (int i = 0; i < list.size(); i++) {

            Iterator<TreeNode> iterator = list.get(i).iterator();
            while (iterator.hasNext()) {
                TreeNode next = iterator.next();
                if (isAncestor(next, p, q)) {
                    accestor = next;
                }
                LinkedList<TreeNode> nextLevel = new LinkedList<>();
                if (next.right != null)
                    nextLevel.add(next.right);
                if (next.left != null)
                    nextLevel.add(next.left);
                if (nextLevel.size() > 0)
                    list.add(nextLevel);
            }

            // 此后 ,将进入到下一层
            if (accestor == null)
                return null;


        }

        return accestor;
    }


    /**
     * 查看任意节点  是不是 p q 的祖先
     */
    private boolean isAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 进行深度优先遍历 , 看看经过次 root 的深度遍历过程中是否包含  p  q
        boolean[] res = {false, false};
        deepSearch(res, root, p.val, q.val);

        return res[0] && res[1];
    }

    private void deepSearch(boolean[] res, TreeNode root, int p, int q) {

        if (root == null)
            return;
        if (root.left != null) {
            deepSearch(res, root.left, p, q);
        }

        if (root.val == p) {
            res[0] = true;
        }
        if (root.val == q) {
            res[1] = true;
        }
        if (root.right != null) {
            deepSearch(res, root.right, p, q);
        }

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(6);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(8);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;

        Solution_0236 so = new Solution_0236();

//        so.lowestCommonAncestor(root, n3, n4);     // true
//        so.lowestCommonAncestor(root, n1, n2);     // true
//        so.lowestCommonAncestor(root, n2, n3);     // true
//        so.lowestCommonAncestor(n1, n3, n4);     // true
//        so.lowestCommonAncestor(n1, n3, n1);     // true

//        so.lowestCommonAncestor(n1, n1, n2);     // false
//        so.lowestCommonAncestor(n1, n3, n5);     // false
//        so.lowestCommonAncestor(n2, n3, n4);     // false
//        so.lowestCommonAncestor(n5, n1, n2);     // false


        System.out.println(so.lowestCommonAncestor(root, n3, n4).val);   //  6
        System.out.println(so.lowestCommonAncestor(root, n3, n5).val);   //  10
        System.out.println(so.lowestCommonAncestor(root, n1, n4).val);   //  6
        System.out.println(so.lowestCommonAncestor(root, n2, n3).val);   //  10

    }


}
