package com.marshal.sort;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2020/1/17
 * @Time: Created at 16:40
 * @Description:
 */

import java.util.Arrays;

/**
 * 冒泡排序
 * 给定数组 [2,1,7,9,5,8]，要求按照从左到右、从小到大的顺序进行排序
 */
public class BubbleSort {

    public void sort(int[] nums) {
        // 用来标记每轮遍历是否发生交换
        boolean hasChange = true;

        for (int i = 0; i < nums.length - 1; i++) {
            // 重置flag进行下次判断
            hasChange = false;
            // 相邻的元素进行比较，每轮结束将较大的数后移，所以每次比较排除前面已排好序的
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    hasChange = true;
                }
            }

            if (!hasChange) {
                break;
            }
        }
    }

    private void swap(int[] arrays, int idx, int idy) {
        int temp = arrays[idx];
        arrays[idx] = idy;
        arrays[idy] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,7,9,5,8};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
