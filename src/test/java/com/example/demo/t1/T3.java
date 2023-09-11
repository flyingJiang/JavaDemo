package com.example.demo.t1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-26 19:02
 **/
public class T3 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        int[] ans = new int[res];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < ans[dp[i] - 1]) {
                ans[dp[i] - 1] = nums[i];
            }
        }
        return res;
    }

    @Test
    public void s1() {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(a));
    }
}
