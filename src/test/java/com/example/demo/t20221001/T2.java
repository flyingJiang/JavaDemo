package com.example.demo.t20221001;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-04 16:39
 **/
public class T2 {
    /**
     * https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/submissions/
     *
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        int lnum = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // 这个方法不要写错
            if (s.charAt(i) == '(') {
                lnum++;
            } else {
                if (lnum > 0) {
                    lnum--;
                } else {
                    ans++;
                }
            }
        }
        return ans + lnum;

    }

    /**
     * 时间上 不如计数
     *
     * @param s
     * @return
     */
    public int minAddToMakeValid2(String s) {
        // 使用栈结构
        int ans = 0;
        if (s.length() == 0) {
            return 0;
        }
        char[] c = s.toCharArray();
        // 记录下表
        Deque<Integer> lIndex = new ArrayDeque<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                lIndex.push(i);
            } else {
                if (lIndex.isEmpty()) {
                    ans++;
                } else {
                    lIndex.pop();
                }
            }
        }
        return ans + lIndex.size();
    }
}
