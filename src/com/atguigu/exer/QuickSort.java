package com.atguigu.exer;/*
 *@Description:
 *@Author:ZhangRuhuan
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
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] > temp){
                high --;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] < temp){
                low ++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = temp;
        return low;
    }
}
/*
①先从队尾开始向前扫描且当low < high时,如果a[high] > tmp,则high–,但如果a[high] < tmp,
则将high的值赋值给low,即arr[low] = a[high],同时要转换数组扫描的方式,即需要从队首开始向队尾进行扫描了
②同理,当从队首开始向队尾进行扫描时,如果a[low] < tmp,则low++,但如果a[low] > tmp了,
则就需要将low位置的值赋值给high位置,即arr[low] = arr[high],同时将数组扫描方式换为由队尾向队首进行扫描.
③不断重复①和②,知道low>=high时(其实是low=high),low或high的位置就是该基准数据在数组中的正确索引位置.
 */