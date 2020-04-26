package com.gh.ds._02.array;

/**
 * 基于 Java 的 Array , 重新封装一个数组
 */
public class MyArray<E> {

    private int size;

    private E[] data;

    public MyArray(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public MyArray() {
        this(10);
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    /**
     * 向数组任意位置  添加元素  . 如果已经存在 , 则覆盖
     *
     * @param index
     * @param e
     */
    private void put(int index, E e) {
        if (index < 0 || index > data.length - 1)
            throw new RuntimeException("illegal index = " + index);
        if (data[index] == null) {
            size++;
        }
        data[index] = e;
    }

    /**
     * 向数组最后一个 位置 添加元素
     * 有空位置时才可以添加
     */
    public void addLast(E e) {
        if (size == data.length)
            throw new RuntimeException("array is full");
        data[size] = e;
        size++;
    }

    /**
     * 获取指定索引位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new RuntimeException("illegal index");
        return data[index];
    }

    public boolean contains(E e) {

        if (e == null)
            return false;
        boolean contain = false;

        for (E d : data) {
            if (e.equals(d)) {
                contain = true;
                break;
            }
        }
        return contain;

    }


}
