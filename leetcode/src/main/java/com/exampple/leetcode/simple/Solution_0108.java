package com.exampple.leetcode.simple;

// 将有序数组转换为二叉搜索树

import com.exampple.leetcode.TreeNode;
import com.sun.org.apache.xalan.internal.lib.NodeInfo;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Solution_0108 {

    /**
     * 解法一 : 如果 TreeNode 中加入 树高度  , 维护一个树高度 . 先实现一个 二分搜索树 , 再在此基础上实现  平衡的维护  以及四种旋转 LL RR LR  RL
     * <p>
     * 解法二 : 因为要实现一个 AVL , 所以 第一次选取数组中间元素作为 根节点 , 之后 分别在其  两边 再次选取 中间元素 最为 此根节点的 左右孩子  , 如此递归进行
     */

    /**
     * 先从中间 选一个 作为 根节点 , 然后在它左右两侧 分别选 左右区间的 中间节点 作为 左右孩子 ,  继续递归  ....
     * <p>
     * 1. 递归方法怎么写 ? 入参是什么
     * 2. 递归到底的 条件是什么
     */
    public TreeNode sortedArrayToBST(int[] nums) {


        if (nums == null || nums.length == 0)
            return null;

        int left = 0;
        int right = nums.length - 1;

        TreeNode info = makeNode(left, right, nums);

        return info;
    }

    /**
     * 入参 : 以数组 的左右边界  , 选取中间来构建  节点
     */
    private TreeNode makeNode(int left, int right, int[] nums) {

        int midIndex = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
//        if (left == right)
//            return root;


        if (midIndex != left)      // midIndex == left 此时只有根节点 , 没有左孩子
            root.left = makeNode(left, midIndex - 1, nums);


        if (midIndex + 1 <= right)
            root.right = makeNode(midIndex + 1, right, nums);

        return root;
    }

    public static void main(String[] args) {
        Solution_0108 so = new Solution_0108();
        TreeNode node = so.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
//        TreeNode n2 = so.sortedArrayToBST(new int[]{1, 2, 3});
        node.inOrder();
    }

}
