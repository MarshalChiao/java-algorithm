package com.marshal.sort;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2020/2/11
 * @Time: Created at 23:04
 * @Description:
 */

import java.util.Arrays;

/**
 * 快速排序
 * 对数组[-9,78,0,23,-567,70]进行从小到大排序
 */
public class QuickSort {

    public void sort(int[] arrays, int left, int right) {
        // 左下标
        int l = left;
        // 右下标
        int r = right;
        // 中轴值
        int pivot = arrays[(left + right) / 2];
        // while循环的目的是让比pivot值小的放到左边，比pivot值大的放到右边
        while (l < r) {
            // 在pivot左边一直找，找到大于等于pivot的值，才退出
            while (arrays[l] < pivot) {
                l += 1;
            }

            // 在pivot右边一直找，找到小于等于pivot的值，才退出
            while (arrays[r] > pivot) {
                r -= 1;
            }
            // 如果 l >= r说明pivot的左右两边的值已经按照左边全部是小于等于pivot的，右边全部是大于pivot的
            if (l >= r) {
                break;
            }

            // 交换
            swap(arrays, l, r);

            // 如果交换完后，发现这个arr[l] == pivot 相等，r-- 前移
            if (arrays[l] == pivot) {
                r -= 1;
            }
            // 如果交换完后，发现这个arr[r] == pivot 相等，l++，后移
            if (arrays[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r，必须 l++， r--，否则会出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 向左递归
        if (left < r) {
            sort(arrays, left, r);
        }
        // 向右递归
        if (right > l) {
            sort(arrays, l, right);
        }
    }

    private void swap(int[] arrays, int idx, int idy) {
        int temp = arrays[idx];
        arrays[idx] = arrays[idy];
        arrays[idy] = temp;
    }

    public static void main(String[] args) {
        int[] arrays = {-9,78,0,23,-567,70};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
    }
}
