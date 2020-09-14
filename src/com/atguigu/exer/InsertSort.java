package com.atguigu.exer;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1,-1,89};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){
        int insertVal = 0; //存放待插入的值
        int insertIndex = 0;//指向待插入位置
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];//存放待插入的值
            insertIndex = i;//指向待插入位置
            while (insertIndex - 1 >= 0 && insertVal > arr[insertIndex - 1]){//从大到小,待插入的值比前一个大
                arr[insertIndex] = arr[insertIndex - 1]; //未找到插入位置就将数据后移（待插入值已经存在insertVal中了，
                // 其位置相当于空了）
                insertIndex -= 1; //指针前移（与前面有序的进行比较）
            }
            arr[insertIndex] = insertVal;
            //循环结束说明找到插入位置了
//            if (insertIndex != i){ //条件满足说明往前找了，默认insertIndex = i ，即insertIndex == i
//                arr[insertIndex] = insertVal; //待插入的值放入插入位置
//            }
        }
    }
}
