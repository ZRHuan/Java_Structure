package com.atguigu.exer;/*
 *@Description:
 *@Author:Zhangruhuan
 *@Time: 2020/9/23 22:17
 */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {0,486,654,34,37,38,745,347,136};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int low,int high){
        if (low < high){
            int index = getIndex(arr,low,high);
            quickSort(arr,low,index - 1);
            quickSort(arr,index + 1,high);
        }
    }

    /**
     *
     * @param arr 数组
     * @param low 左边低位指针
     * @param high 右边高位指针
     */
    public static int getIndex(int[] arr,int low,int high){
        int temp = arr[low];
        while (low < high){
            while (low < high && arr[high] > temp){
                high --;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < temp){
                low ++;
            }
            arr[high] = arr[low];
        }
        if (low >= high){
            arr[low] = temp;
        }
        return low;
    }
}
