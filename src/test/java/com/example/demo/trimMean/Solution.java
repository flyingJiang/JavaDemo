package com.example.demo.trimMean;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-14 21:44
 **/
public class Solution {
    public double trimMean(int[] arr) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=max){
                max = arr[i];
            }
            if (arr[i]<=min) {
                min = arr[i];
            }
            sum+=arr[i];


        }
        return (sum-min-max)/(arr.length-2);

    }
}
