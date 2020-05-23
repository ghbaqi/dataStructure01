package com.gh.ds._11._06.ds;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 自定义 二分搜索树
 */
public class BST<E extends Comparable> {

    private Node<E> root;
    private int size;


    public BST() {
    }

    public BST(E e) {
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

    private Node add(Node<E> root, E e) {
        // 当前节点为空 , 直接作为当前节点
        if (root == null) {
            root = new Node<E>(e);
            size++;
        } else {

            // 比当前节点小 , 往它的左孩子放
            if (e.compareTo(root.e) < 0) {
                root.left = add(root.left, e);

                // 比当前节点大 , 往它的右孩子放
            } else if (e.compareTo(root.e) > 0) {
                root.right = add(root.right, e);
            } else {
                // 已经存在的元素 , 不变化
            }
        }

        return root;
    }


}
