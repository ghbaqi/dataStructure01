package com.gh.ds._08.ds;

/**
 * 基于堆  实现优先队列
 * 优先级为 : 元素越大 优先级越高
 */
public class PriorityQueue<E extends Comparable> {

    private MaxHeap<E> heap;

    public PriorityQueue() {
        heap = new MaxHeap<E>();
    }

    public int getSize() {
        return heap.getSize();
    }

    public boolean isEmpty() {
        return heap.getSize() == 0;
    }

    public void enqueue(E e) {
        heap.add(e);
    }

    public E dequeue() {
        return heap.removeMax();
    }

    /**
     * 看一下 队首 元素是什么
     */
    public E peek() {
        return heap.peek();
    }
}
