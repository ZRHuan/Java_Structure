package com.atguigu.tree.threadedbinarytree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,9,8,5,2};
        heapSort(arr);
    }
    public static void heapSort(int[] arr){
        int temp = 0;
//        System.out.println("堆排序");
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次"+ Arrays.toString(arr));
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次"+ Arrays.toString(arr));

//        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        //arr.length / 2 - 1 为第一个非叶子节点，arr.length / 2为最后一行第一个节点
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
//        将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端；
//        重新调整结构，然后继续交换堆顶元素与当前末尾元素，反复执行 调整+交换 步骤，直到整个序列有序
        for (int j = arr.length - 1; j >= 0 ; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);//重新利用堆结构把最大值放在最顶上
        }
        System.out.println( Arrays.toString(arr));

    }
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];//取出 保存
//        k节点是i节点的左子节点，k+1为i的右子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k+1 < length && arr[k] < arr[k + 1]){
                k++;//k指向右节点，找大的
            }
            if (arr[k] > temp){//子节点大于父节点
                arr[i] = arr[k];//较大的值赋值给当前节点
                i = k;//i指向k，继续循环比较
            }else {
                break;
            }
        }
//        //当for循环结束后，我们已经将以i为父结点的树的最大值，放在了最顶
        arr[i] = temp;
    }
}
