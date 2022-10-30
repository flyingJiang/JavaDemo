package com.example.demo.t20221001;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @program: demoes
 * @description: 784. 字母大小写全排列
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 *
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 *
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 *  
 *
 * 提示:
 *
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 * 通过次数83,384提交次数116,754
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-10-30 13:41
 **/
public class T29letterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        return null;

    }

    /**
     * 方法一：广度优先搜索
     * @param s
     * @return
     */
    public List<String> letterCasePermutation2(String s) {
        List<String> ans = new ArrayList<String>();
        Queue<StringBuilder> queue = new ArrayDeque<StringBuilder>();
        queue.offer(new StringBuilder());
        while (!queue.isEmpty()) {
            StringBuilder curr = queue.peek();
            if (curr.length() == s.length()) {
                ans.add(curr.toString());
                queue.poll();
            } else {
                int pos = curr.length();
                if (Character.isLetter(s.charAt(pos))) {
                    StringBuilder next = new StringBuilder(curr);
                    next.append((char) (s.charAt(pos) ^ 32));
                    queue.offer(next);
                }
                curr.append(s.charAt(pos));
            }
        }
        return ans;
    }

    /**
     * 方法二：回溯
     * @param s
     * @return
     */
    public List<String> letterCasePermutation3(String s) {
        List<String> ans = new ArrayList<String>();
        dfs(s.toCharArray(), 0, ans);
        return ans;
    }

    public void dfs(char[] arr, int pos, List<String> res) {
        while (pos < arr.length && Character.isDigit(arr[pos])) {
            pos++;
        }
        if (pos == arr.length) {
            res.add(new String(arr));
            return;
        }
        arr[pos] ^= 32;
        dfs(arr, pos + 1, res);
        arr[pos] ^= 32;
        dfs(arr, pos + 1, res);
    }

    /**
     * 方法三：二进制位图
     * @param s
     * @return
     */
    public List<String> letterCasePermutation4(String s) {
        int n = s.length();
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(s.charAt(i))) {
                m++;
            }
        }
        List<String> ans = new ArrayList<String>();
        for (int mask = 0; mask < (1 << m); mask++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, k = 0; j < n; j++) {
                if (Character.isLetter(s.charAt(j)) && (mask & (1 << k++)) != 0) {
                    sb.append(Character.toUpperCase(s.charAt(j)));
                } else {
                    sb.append(Character.toLowerCase(s.charAt(j)));
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
