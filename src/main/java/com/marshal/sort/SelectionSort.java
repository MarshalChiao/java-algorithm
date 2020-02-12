package com.marshal.sort;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2020/2/11
 * @Time: Created at 10:26
 * @Description:
 */

import java.util.Arrays;

/**
 * 选择排序
 * 对数组[101,34,119,1]进行从小到大排序
 */
public class SelectionSort {

    public void sort(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            // 用于保存最小的数的下标
            int minIndex = i;
            for (int j = i + 1; j < arrays.length; j++) {
                // 如果还有比最小的数小的数则记录下标
                if (arrays[minIndex] > arrays[j]) {
                    minIndex = j;
                }
            }
            // 如果最小数的下标发生过变化，则将最小数与arrys[i]交换
            if (minIndex != i) {
                swap(arrays, i, minIndex);
            }
        }
    }

    private void swap(int[] arrays, int idx, int idy) {
        int temp = arrays[idx];
        arrays[idx] = arrays[idy];
        arrays[idy] = temp;
    }

    public static void main(String[] args) {
        int[] arrays = {101,34,119,1};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arrays);
        System.out.println(Arrays.toString(arrays));
    }
}
