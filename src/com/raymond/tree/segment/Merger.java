package com.raymond.tree.segment;

/**
 * @author raymondmuzzi
 * @date 2020-05-13 01:11:22
 */
public interface Merger<E> {
    E merge(E e1,E e2);
}
