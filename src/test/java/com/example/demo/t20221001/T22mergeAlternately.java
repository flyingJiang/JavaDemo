package com.example.demo.t20221001;

/**
 * @program: demoes
 * @description: 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * <p>
 * 返回 合并后的字符串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * 示例 2：
 * <p>
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * 示例 3：
 * <p>
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 100
 * word1 和 word2 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-strings-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-10-23 16:12
 **/
public class T22mergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2;
        }
        if (word2 == null || word2.length() == 0) {
            return word1;
        }
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        StringBuilder ans = doMergeAlternately(c1, c2);
        return ans.toString();


    }

    private StringBuilder doMergeAlternately(char[] c1, char[] c2) {
        StringBuilder ans = new StringBuilder();
        if (c1.length >= c2.length) {
            for (int i = 0; i < c1.length; i++) {
                if (i < c2.length) {
                    ans.append(c1[i]);
                    ans.append(c2[i]);
                } else {
                    ans.append(c1[i]);
                }
            }
        } else {
            for (int i = 0; i < c2.length; i++) {
                if (i < c1.length) {
                    ans.append(c1[i]);
                    ans.append(c2[i]);
                } else {
                    ans.append(c2[i]);
                }
            }
        }
        return ans;
    }

    /**
     * 方法一：双指针
     * 思路与算法
     *
     * 我们直接按照题目的要求模拟即可。我们使用两个指针 ii 和 jj，初始时分别指向两个字符串的首个位置。随后的每次循环中，依次进行如下的两步操作：
     *
     * 如果 ii 没有超出 \textit{word}_1word
     * 1
     * ​
     *   的范围，就将 \textit{word}_1[i]word
     * 1
     * ​
     *  [i] 加入答案，并且将 ii 移动一个位置；
     *
     * 如果 jj 没有超出 \textit{word}_2word
     * 2
     * ​
     *   的范围，就将 \textit{word}_2[j]word
     * 2
     * ​
     *  [j] 加入答案，并且将 jj 移动一个位置。
     *
     * 当 ii 和 jj 都超出对应的范围后，结束循环并返回答案即可。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/merge-strings-alternately/solution/jiao-ti-he-bing-zi-fu-chuan-by-leetcode-ac4ih/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;

        StringBuilder ans = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                ans.append(word1.charAt(i));
                ++i;
            }
            if (j < n) {
                ans.append(word2.charAt(j));
                ++j;
            }
        }
        return ans.toString();
    }
}
