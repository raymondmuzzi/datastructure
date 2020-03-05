package com.raymond.recursive;

/**
 * The most simple demo for recursive
 *
 * @author raymondmuzzi
 * @date 2020-03-05 16:50:02
 */
public class RecursiveSum {

    /**
     * Use int value to recursive cal the result
     *
     * @param n
     * @return
     */
    private static int sumInt(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumInt(n - 1);
        }
    }

    /**
     * Use array to recursive cal the result
     *
     * @param arr
     * @return
     */
    private static int sumArray(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        } else {
            int res = arr[arr.length - 1];
            int[] newArr = new int[arr.length - 1];
            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i];
            }
            return res + sumArray(newArr);
        }
    }

    /**
     * More elegant way to recursive cal the array's value
     * This is the best solution
     *
     * @param arr
     * @return
     */
    private static int sumArrayImproved(int[] arr) {
        return sumArrayImproved(arr, 0);
    }

    private static int sumArrayImproved(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sumArrayImproved(arr, l + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(sumArrayImproved(arr));
    }
}
