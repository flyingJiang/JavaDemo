package com.example.demo.maximumSwap;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-13 20:36
 **/
public class Solution {

    public int maximumSwap(int num) {
        // 将数字中右边较大的数字与左边较小的数字进行交换
        // 第一位是否是所有最大的
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        if (n < 1) {
            return num;
        }

        char[] charArraySort = String.valueOf(num).toCharArray();
        Arrays.sort(charArraySort);


        for (int i = 0; i < n; i++) {
            if (charArray[i] < charArraySort[n - 1 - i]) {
                int index = getMaxIndex(charArraySort[n - 1 - i], charArray);
                char temp = charArray[i];
                charArray[i] = charArray[index];
                charArray[index] = temp;
                return Integer.parseInt(new String(charArray));
            }
        }
        return Integer.parseInt(new String(charArray));


    }

    private int getMaxIndex(char c, char[] charArraySort) {
        for (int i = charArraySort.length - 1; i >= 0; i--) {
            if (charArraySort[i] == c) {
                return i;
            }
        }
        return 0;
    }

    @Test
    public void test1() {
        //         // 2736
        // 98368
        System.out.println(
                maximumSwap(2736));
    }
}
