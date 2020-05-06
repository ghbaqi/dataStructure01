package com.gh.ds._07.map;


import java.util.LinkedList;
import java.util.Stack;

/**
 * 自定义 二分搜索树
 */
public class BST<K extends Comparable, V> {

    private Node<K, V> root;
    private int size;


    public BST() {
    }

    public int getSize() {
        return size;
    }


    /**
     * 删除任意元素
     */
    public V remove(K k) {

        boolean contains = contains(k);
        if (!contains)
            return null;

        // 找到待删除节点 和 它的 前驱节点
        Node pre = null;
        Node cur = root;
        while (!cur.k.equals(k)) {

            if (k.compareTo(cur.k) < 0) {
                pre = cur;
                cur = cur.left;
            } else {
                pre = cur;
                cur = cur.right;
            }
        }
        // 此时一定找到了待删除节点 cur

        V retV = (V) cur.v;

        // 1. 待删除节点 同时具有左右孩子
        if (cur.left != null && cur.right != null) {

            // 在右孩子中找到 最小值
            Node minNode = cur.right;
            while (minNode.left != null)
                minNode = minNode.left;
            // 将 minNode 从 cur.right 中删除
            Node newRight = removeMin(cur.right);
            cur.k = minNode.k;
            cur.v = minNode.v;
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

        return retV;
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


    public boolean contains(K k) {
        if (k == null)
            return false;
        return contains(root, k);

    }

    private boolean contains(Node root, K k) {

        if (root == null)
            return false;

        // 当前节点比 待查找元素 大 , 去当前节点的左孩子找
        if (root.k.compareTo(k) > 0) {
            return contains(root.left, k);

            // 当前节点比 待查找节点小 , 去当前节点右孩子找
        } else if (root.k.compareTo(k) < 0) {
            return contains(root.right, k);
        } else {
            return true;
        }
    }

    /**
     * 添加
     */
    public void add(K k, V v) {
        if (k == null)
            throw new RuntimeException("key 不能为 null");
        root = add(root, k, v);
    }

    private Node add(Node<K, V> root, K k, V v) {
        // 当前节点为空 , 直接作为当前节点
        if (root == null) {
            root = new Node(k, v);
            size++;
        } else {

            // 比当前节点小 , 往它的左孩子放
            if (k.compareTo(root.k) < 0) {
                root.left = add(root.left, k, v);

                // 比当前节点大 , 往它的右孩子放
            } else if (k.compareTo(root.k) > 0) {
                root.right = add(root.right, k, v);
            } else {
                // 已经存在的元素 , 不变化
            }
        }

        return root;
    }

    public void set(K k, V v) {
        if (k == null)
            throw new RuntimeException("key 不能为 null");
        root = set(root, k, v);
    }

    private Node set(Node<K, V> root, K k, V v) {
        // 当前节点为空 , 直接作为当前节点
        if (root == null) {
            root = new Node(k, v);
            size++;
        } else {

            // 比当前节点小 , 往它的左孩子放
            if (k.compareTo(root.k) < 0) {
                root.left = set(root.left, k, v);

                // 比当前节点大 , 往它的右孩子放
            } else if (k.compareTo(root.k) > 0) {
                root.right = set(root.right, k, v);
            } else {
                // 已经存在的元素  , 覆盖原来的值
                root.v = v;
            }
        }

        return root;
    }


    public V get(K k) {

        if (k == null || root == null)
            return null;
        Node cur = root;

        while (cur != null) {
            if (k.compareTo(cur.k) < 0) {
                cur = cur.left;
            } else if (k.compareTo(cur.k) > 0) {
                cur = cur.right;
            } else {
                return (V) cur.v;
            }

        }
        return null;
    }
}
