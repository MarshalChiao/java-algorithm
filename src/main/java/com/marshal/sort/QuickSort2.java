package com.marshal.sort;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2020/2/13
 * @Time: Created at 9:10
 * @Description:
 */

import java.util.Arrays;

/**
 * 快速排序
 * 对数组[-9,78,0,23,-567,70]进行从小到大排序
 */
public class QuickSort2 {

    public void sort(int[] arrays, int left, int right) {
        int l = left;
        int r = right;

        //支点
        int pivot = arrays[(left + right) / 2];

        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (l <= r) {

            //寻找直到比支点大的数
            while (pivot > arrays[l]) {
                l++;
            }

            //寻找直到比支点小的数
            while (pivot < arrays[r]) {
                r--;
            }

            //交换
            if (l <= r) {
                int temp = arrays[l];
                arrays[l] = arrays[r];
                arrays[r] = temp;
                l++;
                r--;
            }
        }
        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。

        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (left < r) {
            sort(arrays, left, r);
        }

        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (l < right) {
            sort(arrays, l, right);
        }
    }

    public static void main(String[] args) {
        int[] arrays = {-9, 78, 0, 23, -567, 70};
        QuickSort2 quickSort = new QuickSort2();
        quickSort.sort(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
    }
}
