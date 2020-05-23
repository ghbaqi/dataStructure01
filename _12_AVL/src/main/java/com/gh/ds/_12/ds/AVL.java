package com.gh.ds._12.ds;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 改进  二分搜索树 使之成为 平衡二叉树
 */
public class AVL<E extends Comparable> {

    private Node<E> root;
    private int size;


    public AVL() {
    }

    public AVL(E e) {
        root = new Node<E>(e);
        size++;
    }

    public int getSize() {
        return size;
    }


    /**
     * 删除任意元素
     */
    public boolean remove(E e) {

        boolean contains = contains(e);
        if (!contains)
            return false;

        // 找到待删除节点 和 它的 前驱节点
        Node pre = null;
        Node cur = root;
        while (!cur.e.equals(e)) {

            if (e.compareTo(cur.e) < 0) {
                pre = cur;
                cur = cur.left;
            } else {
                pre = cur;
                cur = cur.right;
            }
        }
        // 此时一定找到了待删除节点 cur

        // 1. 待删除节点 同时具有左右孩子
        if (cur.left != null && cur.right != null) {

            // 在右孩子中找到 最小值
            Node minNode = cur.right;
            while (minNode.left != null)
                minNode = minNode.left;
            // 将 minNode 从 cur.right 中删除
            Node newRight = removeMin(cur.right);
            cur.e = minNode.e;
            cur.right = newRight;

            // 2. 待删除节点 左孩子为空
        } else if (cur.left == null) {

            if (pre.left == cur) {
                pre.left = cur.right;
            } else {
                pre.right = cur.right;
            }

            // 3. 待删除节点 右孩子为空
        } else {
            if (pre.left == cur) {
                pre.left = cur.left;
            } else {
                pre.right = cur.left;
            }

        }
        size--;

        return true;
    }

    /**
     * 从 Node 中删除最小元素 返回新的 节点
     */
    private Node removeMin(Node root) {

        if (root == null)
            return null;

        Node pre = null;
        Node cur = root;
        while (cur.left != null) {
            pre = cur;
            cur = cur.left;
        }

        if (pre == null)
            return root.right;
        pre.left = cur.right;
        return root;
    }

    /**
     * 找到最小值
     */
    public E min() {
        if (root == null)
            return null;

        Node left = root;
        while (left.left != null)
            left = left.left;
        return (E) left.e;

    }

    private E min(Node<E> node) {
        return null;
    }


    /**
     * 删除最小节点
     */
    public E removeMin() {

        if (root == null)
            return null;


        Node pre = null;
        Node left = root;
        // 找到最小节点把它 置为 null
        while (left.left != null) {
            pre = left;
            left = left.left;
        }

        E e;
        // 此时说明  root 是最小的 , 但是可能 root 是具有 右孩子的
        if (pre == null) {
            e = root.e;
            root = root.right;
        } else {
            pre.left = left.right; // 当被删除节点有 右孩子时
            e = (E) left.e;
            left = null;
        }
        size--;
        return e;

    }


    /**
     * 层次遍历
     */
    public void levelOrder_2() {

        if (root == null)
            return;
        LinkedList<Node> list = new LinkedList<Node>();

        // 首相将 root 放入链表
        list.addFirst(root);

        Node first;
        while (!list.isEmpty()) {

            // 总是从 表头移出 一个元素
            first = list.removeFirst();
            System.out.println(first.e);

            // 将被移出元素的 左右孩子 都加入到链表 尾部
            if (first.left != null)
                list.addLast(first.left);
            if (first.right != null)
                list.addLast(first.right);

        }

    }

    /**
     * 层次遍历
     */
    public void levelOrder_1() {

        if (root == null)
            return;
        LinkedList<Node> list = new LinkedList<Node>();
        list.add(root);

        while (!list.isEmpty()) {

            LinkedList<Node> list1 = new LinkedList<Node>();
            for (Node node : list) {
                System.out.println(node.e);
                if (node.left != null)
                    list1.add(node.left);
                if (node.right != null)
                    list1.add(node.right);
            }
            list = list1;

        }

    }

    /**
     * 中序遍历 : 左孩子  根  右孩子
     * 相当于排序
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);

    }


    /**
     * 前序遍历 : 根节点  左孩子  右孩子
     */
    public void preOrder() {

//        preOrder(root);

        // 利用栈实现  非递归前序遍历
        if (root == null)
            return;
        Stack<Node> stack = new Stack<Node>();
        // 1. 先将 根节点 入栈
        stack.push(root);
        Node cur;
        while (!stack.isEmpty()) {

            // 2. 弹出栈顶元素
            cur = stack.pop();
            System.out.println(cur.e);

            // 3 . 将栈顶元素 右孩子 入栈
            if (cur.right != null)
                stack.push(cur.right);

            // 4. 将栈顶元素 左孩子入栈
            if (cur.left != null)
                stack.push(cur.left);
        }


    }

    private void preOrder(Node<E> root) {

        // 当前节点为空
        if (root == null) {
            return;
        } else {
            // 1. 访问根节点
            System.out.println(root.e);

            // 2. 访问左孩子
            if (root.left != null) {
                preOrder(root.left);
            }
            // 3. 访问右孩子
            if (root.right != null) {
                preOrder(root.right);
            }
        }

    }


    public boolean contains(E e) {
        if (e == null)
            return false;
        return contains(root, e);

    }

    private boolean contains(Node<E> root, E e) {

        if (root == null)
            return false;

        // 当前节点比 待查找元素 大 , 去当前节点的左孩子找
        if (root.e.compareTo(e) > 0) {
            return contains(root.left, e);

            // 当前节点比 待查找节点小 , 去当前节点右孩子找
        } else if (root.e.compareTo(e) < 0) {
            return contains(root.right, e);
        } else {
            return true;
        }
    }

    /**
     * 添加
     */
    public void add(E e) {
        if (e == null)
            throw new RuntimeException("树中元素不能为 null");
        root = add(root, e);
    }

    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.h;
    }

    public boolean isBalance() {
        return isBalance(root);
    }

    /**
     * 判断 以 node 为根的 树 是不是 平衡的
     */
    private boolean isBalance(Node<E> node) {

        if (node == null)
            return true;

        if (Math.abs(getBlanceFactor(node)) > 1)
            return false;

        return isBalance(node.left) && isBalance(node.right);
    }

    private int getBlanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E key) {

        if (node == null) {
            size++;
            return new Node(key);
        }

        if (key.compareTo(node.e) < 0)
            node.left = add(node.left, key);
        else if (key.compareTo(node.e) > 0)
            node.right = add(node.right, key);
        // else // key.compareTo(node.key) == 0


        // 更新height
        node.h = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBlanceFactor(node);

        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBlanceFactor(node.left) >= 0)
            return rightRotate(node);

        // RR
        if (balanceFactor < -1 && getBlanceFactor(node.right) <= 0)
            return leftRotate(node);

        // LR
        if (balanceFactor > 1 && getBlanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBlanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * 如何维护节点的 高度 ?
     */
    private Node add_1(Node<E> root, E e) {
        // 当前节点为空 , 直接作为当前节点
        if (root == null) {
            root = new Node<E>(e);
            size++;
        } else {

            // 比当前节点小 , 往它的左孩子放
            if (e.compareTo(root.e) < 0) {
                root.left = add_1(root.left, e);

                // 比当前节点大 , 往它的右孩子放
            } else if (e.compareTo(root.e) > 0) {
                root.right = add_1(root.right, e);
            } else {
                // 已经存在的元素 , 不变化
            }
        }

        // 在这里维护 节点 高度
        root.h = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balanceFactor = getHeight(root.left) - getHeight(root.right);

        /**
         *  平衡维护
         *
         * 由于新加入的节点 , 导致该节点不平衡 ,
         * 因此需要对这个节点进行  reblance
         *
         * LL
         * RR
         * LR
         * RL
         */

        if (Math.abs(balanceFactor) >= 2) {
            // System.out.println("需要 rebalance node.v = " + root.e);

            if (balanceFactor >= 2 && getBlanceFactor(root.left) >= 0) {
                // LL
                return rightRotate(root);
            } else if (balanceFactor >= 2 && getBlanceFactor(root.left) < 0) {
                // LR
                // 先对 node.left 左旋 , 再对 node 右旋
                root.left = leftRotate(root.left);
                return rightRotate(root);

            } else if (balanceFactor <= -2 && getBlanceFactor(root.right) <= 0) {
                // RR
                return leftRotate(root);
            } else if (balanceFactor <= -2 && getBlanceFactor(root.right) > 0) {
                // RL
                root.right = rightRotate(root.right);
                return leftRotate(root);
            } else {
                throw new RuntimeException("未知的 平衡状态");
            }

        }

        //  System.out.println("节点 value = " + root.e + " , left h = " + getHeight(root.left) + " , right h = " + getHeight(root.right));

        // 此时是平衡 的
        return root;
    }

    /**
     * LL  在左侧的左侧添加元素导致了  不平衡
     * <p>
     * // 对节点y进行向右旋转操作，返回旋转后新的根节点x
     * //        y                              x
     * //       / \                           /   \
     * //      x   T4     向右旋转 (y)        z     y
     * //     / \       - - - - - - - ->    / \   / \
     * //    z   T3                       T1  T2 T3 T4
     * //   / \
     * // T1   T2
     */

// wode
    public Node rightRotate(Node y) {

        Node x = y.left;     //
        Node t3 = x.right;  //

        // 先对 y 进行右旋
        x.right = y;       //
        y.left = t3;      //


        // 由于只有 x  y  高度发生变化 , 因此对他们的高度进行重新维护
        y.h = 1 + Math.max(getHeight(y.left), getHeight(y.right));      //  踩坑  ! ! ! ! !  对于 x y 高度的维护 , 不能颠倒顺序
        x.h = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        // 返回旋转后的  新的 根节点
        return x;

    }


    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    // wode
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // 向左旋转过程
        x.left = y;
        y.right = T2;

        // 更新height
        y.h = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.h = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }


}
