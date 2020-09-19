package com.atguigu.search;

import java.util.Arrays;

public class FibonaciiSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println(fibSearch(arr,1));
    }
    //    //因为后面我们mid=1ow+F(k-1)-1
//使用到斐波那契数
//此我们需要先获取
//婓波那契
////非递归方法得
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
    public static int fibSearch(int[] a,int findVal){
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;//存放mid值
        int[] f = fib();//获取到斐波那契数列
        while (high > f[k] - 1){//比较长度
            k++;
        }
//        //因为f[k]值可能大于a的长度，因此我们需要使用 Arrays类，构造一个新的数组，并指向temp
////不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a,f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];//实际上需求使用a数组最后的数填充temp
        }
        while (low <= high){
            mid = low + f[k - 1] - 1;
            if (findVal < temp[mid]){
                high = mid - 1;
//                //为甚是k
////说明
////1,全部元素 = 前面的元素 + 后面的元素
//f[k] = f[k-1] + f[k-2]
////因为前面有f[k-1]个元素，所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
////即在f[k-1]的前面继续查找k--
////即下次循环mid=f[k-1-1]-1
                k--;
            }else if (findVal > temp[mid]){
                low = mid + 1;
                ////1,全部元素 = 前面的元素 + 后面的元素
//f[k] = f[k-1] + f[k-2]
////因为前面有f[k-2]个元素，所以可以继续拆分f[k-2] = f[k-3] + f[k-4]
////即在f[k-2]的前面继续查找k-=2
////即下次循环mid=f[k-1-2]-1
                k -= 2;
            }else {
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
