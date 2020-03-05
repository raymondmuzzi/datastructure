package com.raymond.array;

/**
 * @author raymondmuzzi
 * @date 2020-02-23 16:54:19
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity，构造Array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造器，默认大小为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中，有数据元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数据中包含空元素的所有空间
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在数组最后添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在数组的头部添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在指定的位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new RuntimeException("Add failed, requires index >= 0 and index <= size.");
        }

        if (size == data.length) {
            resize(data.length * 2);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 根据索引获取元素的内容
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Get failed, Index is illegal");
        }
        return data[index];
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 为指定位置设置元素的内容
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Set failed, Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 判断数组中是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return find(e) != -1;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在则返回-1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 移除数组中某个元素，返回删除的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("Remove failed, Index is illegal");
        }
        E result = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null; // loitering objects

        // 对数组进行缩容，防止复杂度动荡
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return result;
    }

    /**
     * 移除第一个元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 移除最后一个元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 移除指定第一次出现的元素
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        try {
            remove(index);
        } catch (RuntimeException e1) {
            throw new RuntimeException("No such element " + e);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        result.append('[');
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append(']');
        return result.toString();
    }

    /**
     * 如果数组满了，进行动态扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
