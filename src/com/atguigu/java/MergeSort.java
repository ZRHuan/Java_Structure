package com.atguigu.java;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr= {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergesort(arr,0,arr.length - 1,temp);
        System.out.println("归并排序后" + Arrays.toString(arr));
    }
    public static void mergesort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            mergesort(arr,left,mid,temp);
            mergesort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

//        /把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid){//左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right){//右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        t = 0;
        int tempLeft = left;
        System.out.println("tempLeft=" + tempLeft + "  right=" + right);
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
