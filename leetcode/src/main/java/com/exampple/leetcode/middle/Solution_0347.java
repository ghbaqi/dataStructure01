package com.exampple.leetcode.middle;

import java.util.*;

// 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

/**
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class Solution_0347 {
    /**
     * 定义一个数据结构 (int val , int frep)
     * 第一遍遍历数据 , 统计出每个元素的 频率
     * 根据频率排序  , 取出前 K 个
     */

    /**
     * 定义一个数据结构 (int val , int frep)
     * 第一遍遍历数据 , 统计出每个元素的 频率
     * 自定义最大堆 , 当堆中元素个数大于 k 个时 , 移除最后一个               ×  ×  ×  ×  ×  ×   这样不行 , 最后一个元素并不是最小的
     */


    /**
     * 定义一个数据结构 (int val , int frep)
     * 第一遍遍历数据 , 统计出每个元素的 频率
     * 自定义最小堆 , 当堆中元素大于 k 个时 , 移除堆顶元素
     */
    public int[] topKFrequent(int[] nums, int k) {


        // O(n)
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        // O(n)
        MaxHeap<NumFreq> heap = new MaxHeap<NumFreq>();

        for (Integer key : map.keySet()) {
            heap.add(new NumFreq(key, map.get(key)));
            if (heap.getSize() > k) {
                heap.removeMax();   // 此时将频率小的 移出去了 , 只最多保留 k 个 频率大的元素
            }

        }


        // O(log n)
        if (heap.getSize() == 0)
            return null;
        int[] ints = new int[heap.getSize()];
        int index = 0;
        while (!heap.isEmpty()) {
            ints[index] = heap.removeMax().val;
            index++;
        }
        return ints;

    }

    // 修改 compreTo 方法, 此时按照现在的排序  ,  是一个最小堆
    public class NumFreq implements Comparable {

        public int val;
        public int freq = 1;

        public NumFreq(int val) {
            this.val = val;
        }

        public NumFreq(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        // frep 越小 , 优先级越高
        public int compareTo(Object o2) {
            return ((NumFreq) o2).freq - this.freq;
        }
    }

    public class MaxHeap<E extends Comparable> {

        private ArrayList<E> list;


        public MaxHeap() {
            list = new ArrayList<E>(10);
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

        // × ×  × × ×  并不是最小元素
//        public E removeMin() {
//            if (list.size() == 0)
//                return null;
//            return list.remove(list.size() - 1);
//        }

    }


    public static void main(String[] args) {
        Solution_0347 so = new Solution_0347();
        int[] ints = so.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);  // -1  2
        for (int i : ints) {
            System.out.println(i);
        }
    }

}
