package com.example.demo.arrayRankTransform;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: demoes
 * @description: https://leetcode.cn/problems/rank-transform-of-an-array/submissions/
 * @author: jiangjianfei
 * @create: 2022-07-28 23:06
 **/
public class Solution {

    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        // 先去除重复
        // 然后排序，获得唯一下标
        Arrays.sort(sortedArr);
        Map<Integer, Integer> ranks = new HashMap<Integer, Integer>();
        for (int a : sortedArr) {
            if (!ranks.containsKey(a)) {
                ranks.put(a, ranks.size() + 1);
            }
        }
        // 遍历替换
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = ranks.get(arr[i]);
        }
        return ans;
    }
}
