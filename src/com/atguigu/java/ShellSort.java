package com.atguigu.java;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        int[] arr = new int[200000];
        for (int i = 0; i < 200000; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
//        System.out.println("排序前");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date);
        System.out.println("排序前的时间是=" + date1Str);
        shellSort(arr);
//        System.out.println("排序后");
        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + date2Str);
    }
    public static void shellSort(int[] arr){
        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2;gap > 0; gap /= 2){
            for (int i = gap; i < arr.length ; i++) {
                for (int j = i-gap; j >= 0 ; j -= gap) {
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序"+(++count)+"轮后" + Arrays.toString(arr));

        }
    }
public static void shellSort2(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap > 0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }

            }
        }
}
}
