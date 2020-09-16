package com.atguigu.search;

import java.util.ArrayList;

//注意：使用二分查找的前提是该数组是有序的，
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1000,1234};
//        int resIndex = binarySearch(arr,0,arr.length - 1,88);
//        System.out.println("resIndex = " + resIndex);
        ArrayList<Integer> index = binarySearch2(arr,0,arr.length - 1,1000);
        System.out.println("index = " + index);
    }
    public static int binarySearch(int[] arr,int left ,int right,int findVal){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if(findVal > midVal){
            return binarySearch(arr,mid + 1,right,findVal);
        }else if (findVal < midVal){
            return binarySearch(arr,left,mid - 1,findVal);
        }else {
            return mid;
        }
    }


//    思路分析   有重复的数
//1.在找到mid素引值，不要马上返回
//2.向mid素引值的左边扫描，将所有满足1000,的元素的下标，加入到集合 Arraylist
//3.向mid索引值的右边扫描，将所有满足1090,的元素的下标，加入到集合 Arraylist
//4.将 Array1ist返回
    public static ArrayList<Integer> binarySearch2(int[] arr, int left , int right, int findVal){
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if(findVal > midVal){
            return binarySearch2(arr,mid + 1,right,findVal);
        }else if (findVal < midVal){
            return binarySearch2(arr,left,mid - 1,findVal);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }else {
                    list.add(temp);
                    temp --;
                }
            }
            list.add(mid);//添加中间的数
            temp = mid + 1;

            while (true){
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }else {
                    list.add(temp);
                    temp ++;
                }
            }
            return list;
        }
    }
}
