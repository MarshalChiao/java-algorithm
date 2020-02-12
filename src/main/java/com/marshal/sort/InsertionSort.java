package com.marshal.sort;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2020/1/17
 * @Time: Created at 17:28
 * @Description:
 */

import java.util.Arrays;

/**
 * 插入排序
 * 对数组 [2,1,7,9,5,8] 从小到大的顺序进行插入排序
 */
public class InsertionSort {

    public void sort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            // current表示待插入的数
            int current = arrays[i];
            // insertIndex表示已排好序的数组的最右端开始比较
            int j = i - 1;

            // 对i左侧的数一个一个与current比较，大于current右移1位
            while (j >= 0 && current < arrays[j]) {
                // 如果待插入的数小于当前数，当前数则右移一位
                arrays[j + 1] = arrays[j];
                j--;
            }

            // 所有大于current的值都右移一位后，j+1的位置就为current插入的位置
            arrays[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arrays = {2,1,7,9,5,8};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
