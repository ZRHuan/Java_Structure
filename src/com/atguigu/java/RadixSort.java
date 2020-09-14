package com.atguigu.java;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
    }
    //第1轮（针对每个元素的个位进行排序处理）
    //定义一个二维数组，表示10个桶。每个桶就是一个一维数组
//说明
//1.二维数组包含10个一维数组
//2.为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定为arr.length
//3.名明确，基数排序是使用空间换时间的经典算法
    public static void radixSort(int[] arr){
        //找最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();//求最大值的位数
        int[][] bucket = new int[10][arr.length];//10个一维数组（桶）存放数据
        //为了记录每个桶中，实际存放了多少个数据，我们定义ー个一数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0,n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j <arr.length ; j++) {
                //第1轮（针对每个元素的个位进行排序处理）
                int digitOfElement = arr[j] / n % 10;//53
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement] ++ ;
            }
            //按照这个桶的顺序（一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            //遍历每一桶，并将桶中数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {//10
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0){
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第1轮处理后，需要将每个 bucketElementCounts[k]=0!!!!!
                bucketElementCounts[k] = 0;
            }
            System.out.println("第"+(i+1)+"轮，对个位的排序处理arr=" + Arrays.toString(arr));
        }

    }

}
