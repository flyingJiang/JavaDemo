package com.example.demo.t1;

import org.junit.Test;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-26 19:12
 **/
public class T4 {

    public int chengeTwoString(String str1, String str2, int ic, int dc, int rc) {
        char[] str1s = str1.toCharArray();
        char[] str2s = str2.toCharArray();
        int m = str1s.length;
        int n = str2s.length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = i * dc;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = i * ic;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int min1 = Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic);
                if (str1s[i] == str2s[j]) {
                    dp[i][j] = Math.min(min1, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(min1, dp[i - 1][j - 1] + rc);
                }
            }
        }
        //输出矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    @Test
    public void s1() {
        System.out.println(chengeTwoString("ab12cd3", "abcdf", 5, 3, 2));
    }
}
