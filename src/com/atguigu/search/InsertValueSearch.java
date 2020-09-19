package com.atguigu.search;

import java.util.Arrays;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = i + 1;
        }
        int index = insertSearchValue(arr,0,arr.length - 1,99);
        System.out.println(index);
//        System.out.println(Arrays.toString(arr));
    }
    public static int insertSearchValue(int[] arr,int left , int right, int findVal){
        System.out.println("插值查找");
        if (findVal < arr[0] || findVal > arr[arr.length - 1] || left > right){
            return -1;
        }
        int mid = left + (right - left)*(findVal - arr[left])/(arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){
            return insertSearchValue(arr,mid + 1,right,findVal);
        }else if (findVal < midVal){
            return insertSearchValue(arr,left,mid - 1,findVal);
        }else {
            return mid;
        }
    }
}
