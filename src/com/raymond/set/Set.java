package com.raymond.set;

/**
 * @author raymondmuzzi
 * @date 2020-05-05 02:06:43
 */
public interface Set<E> {

    /** add the element e */
    void add(E e);

    /** remove the element e */
    void remove(E e);

    /** judge contains element e or not */
    boolean contains(E e);

    /** get the size of the set's size */
    int getSize();

    /** judge the set is empty or not */
    boolean isEmpty();
}
