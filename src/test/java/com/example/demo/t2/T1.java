package com.example.demo.t2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: demoes
 * @description: https://leetcode.cn/problems/check-permutation-lcci/solution/pan-ding-shi-fou-hu-wei-zi-fu-zhong-pai-dmkmc/
 * @author: jiangjianfei
 * @create: 2022-09-27 16:14
 **/
public class T1 {
    /**
     * 官方参考
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    /**
     * 我的
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation2(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        if (s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 方法二：哈希表
     * 方法二：哈希表
     * 从另一个角度考虑，字符串 s_1s
     * 1
     * ​
     *   和 s_2s
     * 2
     * ​
     *   互为字符重排等价于「两个字符串中字符出现的种类和次数均相等」。由于字符串只包含 128128 种不同的字符，因此我们可以维护一个长度为 128128 的频次数组 \textit{table}table，先遍历记录字符串 s_1s
     * 1
     * ​
     *   中字符出现的频次，然后遍历字符串 s_2s
     * 2
     * ​
     *  ，减去 \textit{table}table 中对应的频次，如果出现 \textit{table}[i]<0table[i]<0，则说明 s_2s
     * 2
     * ​
     *   包含一个不在 s_1s
     * 1
     * ​
     *   中的额外字符，返回 \text{false}false 即可。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/check-permutation-lcci/solution/pan-ding-shi-fou-hu-wei-zi-fu-zhong-pai-dmkmc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation3(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] table = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            table[s2.charAt(i)]--;
            if (table[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        String s1 = "abc";
        String s2 = "bca";
        CheckPermutation2(s1, s2);
    }
}
