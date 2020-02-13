package com.marshal.sort;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2020/2/13
 * @Time: Created at 10:23
 * @Description:
 */

import java.util.Arrays;

/**
 * 归并排序
 * 对数组 [2,1,7,9,5,8] 从小到大的顺序进行排序
 */
public class MergeSort {

    public void sort(int[] arr, int left, int right) {
        if (left < right) {
//            int mid = left + (right - left) / 2;
            int mid = (left + right) / 2;
            // 左边归并排序，使左子序列有序
            sort(arr, left, mid);
            // 右边归并排序，使右子序列有序
            sort(arr, mid + 1, right);
            // 将两个有序序列合并
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        // 左边序列的指针
        int l = left;
        // 右边序列的指针(mid为中间索引)
        int r = mid + 1;
        // 临时数组的下标
        int t = 0;

        // 将两个序列中的数一一比较后放入临时队列
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                // 左边值小于右边，将左边值放入临时队列
                temp[t++] = arr[l++];
            } else {
                // 右边小于左边，将右边放入临时队列
                temp[t++] = arr[r++];
            }
        }

        // 左边剩下的值依次放入临时队列
        while (l <= mid) {
            temp[t++] = arr[l++];
        }

        // 右边剩下的值依次放入临时队列
        while (r <= right) {
            temp[t++] = arr[r++];
        }

        // 将临时队列的内容全部拷贝到原数组中去
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 7, 9, 5, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
