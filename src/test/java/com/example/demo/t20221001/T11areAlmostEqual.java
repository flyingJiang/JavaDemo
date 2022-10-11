package com.example.demo.t20221001;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demoes
 * @description: 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * 示例 2：
 * <p>
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * 示例 3：
 * <p>
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * 示例 4：
 * <p>
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-10-11 22:19
 **/
public class T11areAlmostEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();
        int diff = 0;
        char a1 = 'a', a2 = 'a', b1 = 'a', b2 = 'a';
        for (int i = 0; i < len; i++) {
            if (!s1.contains(String.valueOf(s2.charAt(i)))) {
                return false;
            }
            if (s1.charAt(i) != (s2.charAt(i))) {
                diff++;
                if (diff == 1) {
                    a1 = s1.charAt(i);
                    b1 = s2.charAt(i);
                }
                if (diff == 2) {
                    a2 = s1.charAt(i);
                    b2 = s2.charAt(i);

                }
                if (diff > 2) {
                    return false;
                }
            }
        }
        if (diff == 0) {
            return true;
        }
        if (diff == 2 && a1 == b2 && a2 == b1) {
            return true;
        }
        return false;

    }

    public boolean areAlmostEqual2(String s1, String s2) {
        int n = s1.length();
        List<Integer> diff = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff.size() >= 2) {
                    return false;
                }
                diff.add(i);
            }
        }
        if (diff.isEmpty()) {
            return true;
        }
        if (diff.size() != 2) {
            return false;
        }
        return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) && s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));

    }
}
