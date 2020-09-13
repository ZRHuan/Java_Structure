package com.atguigu.java;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {9,8,5,0,-2,1,0};
//        int[] arr = {-9,-2,-567,-1,0,8,0,23,-567,70,5,78,900,};
//        int[] arr = {-9,-2,-567,-1,-567,8,0,23,0,70,5,78,900,};
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
//        System.out.println("排序前");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date);
        System.out.println("排序前的时间是=" + date1Str);
        quicksort(arr,0,arr.length - 1);
//        System.out.println("排序后");
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + date2Str);

//        quicksort(arr,0,arr.length -1);
//        System.out.println(Arrays.toString(arr));
    }
    public static void quicksort(int[] arr, int left, int right){
        int l = left;
        int r =right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        int count = 0;
//        找并交换位置
        while (l < r){
            while (arr[l] < pivot){
                l += 1;
            }
            while (arr[r] > pivot){
                r -= 1;
            }
            //如果1>=r说明 pivot的左右两的值，已经按照左边全部是
            //小于等于 pivot值，右边全部是大于等于 pivot值
            if (l >= r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
//            /如果交换完后，发现这个arr[l]== pivot值相等,则r--,前移
            if (arr[l] == pivot){
                r -= 1;
            }
            if (arr[r] == pivot){
                l += 1;
            }
        }

//        递归
        if (l == r){
            l += 1;
            r -= 1;
        }
        if (left < r){
            quicksort(arr,left,r);
        }
        if (right > l){
            quicksort(arr,l,right);
        }
    }
}
