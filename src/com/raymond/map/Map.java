package com.raymond.map;

/**
 * @author raymondmuzzi
 * @date 2020-05-05 19:14:52
 */
public interface Map<K, V> {

    /** 添加元素 */
    void add(K key, V value);

    /** 移除元素 */
    V remove(K key);

    /** 判断是否包含某个以key为键的元素 */
    boolean contains(K key);

    /** 获取以key为键的value值 */
    V get(K key);

    /** 设置key的值为value */
    void set(K key, V newValue);

    /** 获取map的size */
    int getSize();

    /** 判断map是否为空 */
    boolean isEmpty();

}
