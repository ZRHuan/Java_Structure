package com.atguigu.exer;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr){//交换法
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
    public static void shellSort2(int[] arr){//移位法
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++) {//从arr[gap] 开始逐渐往后，每一组数据进行插入排序
                int Index = i;
                int temp = arr[Index];//
                if (arr[Index] < arr[Index - gap]){
                    while (Index - gap > 0 && temp < arr[Index - gap]){
                        arr[Index] = arr[Index - gap];//前一个后移
                        Index -= gap;//指针前移
                    }
                    arr[Index] = temp;
                }

            }
        }
    }
}
