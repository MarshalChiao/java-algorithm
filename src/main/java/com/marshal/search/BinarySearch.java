package com.marshal.search;

/**
 * @Author: Shaoshuai Jiao
 * @Date: Created on 2020/2/24
 * @Time: Created at 22:54
 * @Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 * 数组[1,8,10,89,1000,1234]进行查找1000
 */
public class BinarySearch {

    /**
     * 查找元素，找到第一个就返回下标
     * @param arrays
     * @param left  左边下标
     * @param right 右边下标
     * @param value 待查找值
     * @return
     */
    public int search(int[] arrays, int left, int right, int value) {
        // 当left > right 时，说明递归了整个数组，但是没有找到
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midValue = arrays[mid];
        if (value > midValue) { // 向右递归
            return search(arrays, mid + 1, right, value);
        } else if (value < midValue) { // 向左递归
            return search(arrays, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    /**
     * 找到有序数组中所有相同的元素返回下标集合
     * 分析：
     * 1.找到mid索引值时不要马上返回
     * 2.向mid的左右两边扫描，将所有满足的下标加入list中
     * 3.返回list
     * @param arrays
     * @param left
     * @param right
     * @param value
     * @return
     */
    public List searchAll(int[] arrays, int left, int right, int value) {
        if (left > right) {
            return new ArrayList();
        }

        int mid = (left + right) / 2;
        int midValue = arrays[mid];
        if (value > midValue) {
            return searchAll(arrays, mid + 1, right, value);
        } else if (value < midValue) {
            return searchAll(arrays, left, mid - 1, value);
        } else {
            List<Integer> indexList = new ArrayList<Integer>();
            // 向mid索引值的左边扫描
            int temp = mid -1;
            while (true) {
                if (temp < 0 || arrays[temp] != value) {
                    break;
                }
                // 否则，就将temp放入到list
                indexList.add(temp);
                temp--;
            }
            // 放入原本找到的mid
            indexList.add(mid);
            // 向mid索引值的邮编扫描
            temp = mid + 1;
            while (true) {
                if (temp > arrays.length-1 || arrays[temp] != value) {
                    break;
                }
                indexList.add(temp);
                temp++;
            }
            return indexList;
        }
    }

    public static void main(String[] args) {
        int[] arrays = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        int value = 1000;
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.search(arrays, 0, arrays.length - 1, value);
        System.out.println("数组下标为：" + result);
        List list = binarySearch.searchAll(arrays, 0, arrays.length - 1, value);
        System.out.println("数组的下标集合为：" + list);
    }
}
