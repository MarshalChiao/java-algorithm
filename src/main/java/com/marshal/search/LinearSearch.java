package com.marshal.search;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2020/2/24
 * @Time: Created at 21:19
 * @Description:
 */

/**
 * 线性查找
 * 数组 [1,9,11,-1,34,89] 中查找 11 并返回下标1
 */
public class LinearSearch {

    public int search(int[] arrays, int value) {
        // 逐一比对，发现相同值，返回下标
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // 没有顺序的数组
        int[] arrays = {1,9,11,-1,34,89};
        int value = 11;
        LinearSearch linearSearch = new LinearSearch();
        int result = linearSearch.search(arrays, value);
        if (result == -1) {
            System.out.println("没有查找到");
        } else {
            System.out.println("找到，下标为：" + result);
        }
    }
}
