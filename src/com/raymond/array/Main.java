package com.raymond.array;

/**
 * @author raymondmuzzi
 * @date 2020-02-23 16:28:42
 */
public class Main {
    public static void main(String[] args) {
        Array<Student> studentArray = new Array<>();
        for (int i = 0; i < 10000; i++) {
            studentArray.addLast(new Student("Alice-" + i, 100));
        }
        System.out.println(studentArray);
    }
}