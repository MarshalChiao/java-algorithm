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

    public void sort(int[] nums) {
        for (int i = 1, j, current; i < nums.length; i++) {
            current = nums[i];

            for (j = i - 1; j >= 0 && nums[j] > current; j--) {
                nums[j + 1] = nums[j];
            }

            nums[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1,7,9,5,8};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
