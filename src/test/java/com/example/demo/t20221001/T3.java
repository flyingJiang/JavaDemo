package com.example.demo.t20221001;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-04 17:06
 **/
public class T3 {

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
/*
    作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/solution/jian-cha-er-jin-zhi-zi-fu-chuan-zi-duan-b1phi/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public boolean checkOnesSegment2(String s) {
        int c1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (i > 0 && s.charAt(i - 1) != '1') {
                    c1++;
                }
                if (i == 0) {
                    c1++;
                }
            }
            if (c1 > 1) {
                return false;
            }
        }
        return true;
    }
}
