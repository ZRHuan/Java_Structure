package com.atguigu.exer;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
        int[] temp = new int[arr.length];// 新建一个临时数组用来存放排好序的数
        mergeSort(arr,0,arr.length - 1,temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr , int left, int right,int[] temp){
        if (left < right){
            int middle = (left + right) / 2;//// 取中间值
            mergeSort(arr,0,middle,temp);// 对中间值左边进行排序----不断拆分
            mergeSort(arr,middle + 1,right,temp);// 对中间值右边进行排序----不断拆分
            merge(arr,left,middle,right,temp);// 将左右两个排好序的数组进行合并
        }

    }
    public static void merge(int[] arr, int left, int middle, int right,int[] temp){
        int l = left;// 左边数组的第一个下标
        int r = middle + 1;// 右边数组的第一个下标
        int t = left;// 临时数组tmp的最左边的下标

        // 当两个数组都没到末尾时,谁小,将谁先放进临时数组tmp
        while (l <= middle && r<= right){
//            if (arr[l] < arr[r]){
//                temp[t++] = arr[l++];
//            }else {
//                temp[t++] = arr[r++];
//            }
            temp[t++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        }
        // 能走到这里有两种情况,或者l>middle了,或者r>right了,
        // 也就是左边或右边至少有一个数组已经全部放到新数组tmp里了

        // 如果这时候ls<=middle,则此时ls~middle的值比已经放进tmp的数都大,只需将其依次放入tmp就好了
        while (l <= middle ){
            temp[t++] = arr[l++];
        }

        // 同理,如果此时rs<=right,说明此时rs~right的值比已经放进tmp的数都大,只需将其依次放入tmp就好了
        while (r <= right){
            temp[t++] = arr[r++];
        }
        // 将tmp数组赋值给arr------tmp是有序数组
        while (left <= right){
            arr[left] = temp[left];
            left++;
        }
    }
}
