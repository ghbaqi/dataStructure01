package com.gh.ds._08.ds;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.javac.jvm.ByteCodes.*;

/**
 * 基于动态数组 作为底层存储结构 实现最大堆
 * 1. 首先是一个完全二叉树
 * 2. 任意节点大于它的孩子节点
 */

/**
 * 任意索引 i 的左右孩子 : 2i + 1  , 2i + 2
 * 任意索引 j 的父亲节点 : (j-1)/2
 */
public class MaxHeap<E extends Comparable> {

    private ArrayList<E> list;

    public MaxHeap(ArrayList<E> list) {
        heapify(list);
    }

    public MaxHeap() {
        list = new ArrayList<E>(10);
    }

    public MaxHeap(int capacity) {
        list = new ArrayList<E>(capacity);
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    /**
     * 获取一个节点的父亲
     */
    private int parent(int index) {
        if (index == 0)
            throw new RuntimeException("root 节点没有父亲");
        return (index - 1) / 2;
    }

    private int leftChild(int parent) {
        return parent * 2 + 1;
    }

    private int rightChild(int parent) {
        return parent * 2 + 2;
    }

    /**
     * 向堆中添加元素
     */
    public void add(E e) {
        if (e == null)
            throw new RuntimeException("堆中不能添加空元素");

        list.add(e);
        int curIndex = list.size() - 1;

        // 新添加的元素总是在最后一个叶子节点 , 然后进行慢慢 sift up
        siftUp(curIndex);

    }

    /**
     * 取出堆顶元素
     */
    public E removeMax() {

        if (list.isEmpty())
            return null;
        if (list.size() == 1)
            return list.remove(0);
        E max = list.get(0);

        // 将最后一个元素 赋值给 第一个元素
        list.set(0, list.remove(list.size() - 1));

        // 此时 0 位置元素较小 , 向下交换
        siftDown(0);

        return max;
    }

    private void siftDown(int parent) {

        int leftIndex = leftChild(parent);
        int rightIndex = leftIndex + 1;

        // 1. 先找出左右孩子中  较大的那个
        int bigChildIndex = -1;
        if (rightIndex <= list.size() - 1) {
            bigChildIndex = list.get(leftIndex).compareTo(list.get(rightIndex)) > 0 ? leftIndex : rightIndex;
        } else if (leftIndex <= list.size() - 1) {
            bigChildIndex = leftIndex;
        }

        // 2 . 如果没有左右孩子 , 不需要交换
        if (bigChildIndex == -1)
            return;

        // 3. 与较大的左右孩子  进行交换
        if (list.get(parent).compareTo(list.get(bigChildIndex)) < 0) {
            swap(parent, bigChildIndex);

            // 4. 继续递归交换
            siftDown(bigChildIndex);
        }
    }

    private void siftUp(int curIndex) {
        if (curIndex == 0)
            return;
        int parentIndex = parent(curIndex);

        while (list.get(curIndex).compareTo(list.get(parentIndex)) > 0) {

            swap(parentIndex, curIndex);
            curIndex = parentIndex;
            if (curIndex == 0)
                return;
            parentIndex = parent(curIndex);
        }
    }

    private void swap(int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public void print() {
        System.out.println("size = " + getSize());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("index = " + i + " , val = " + list.get(i));
        }
    }

    /**
     * 将任意数组 整理成 符合堆的 元素顺序
     * <p>
     * 1. 首先将已有数组看成是一个 堆序
     * 2. 从最后一个  非叶子节点 开始 进行 siftDown
     */
    public void heapify(ArrayList<E> list) {
        if (list == null || list.size() == 0)
            return;
        this.list = list;

        int lastParent = (list.size() - 1) / 2;
        while (lastParent >= 0) {
            siftDown(lastParent);
            lastParent--;
        }


    }


    public E peek() {
        if (list.size() == 0)
            return null;
        return list.get(0);
    }
}
