package t202211;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: demoes
 * @description: 1684. 统计一致字符串的数目
 * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
 *
 * 请你返回 words 数组中 一致字符串 的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * 输出：2
 * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
 * 示例 2：
 *
 * 输入：allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * 输出：7
 * 解释：所有字符串都是一致的。
 * 示例 3：
 *
 * 输入：allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * 输出：4
 * 解释：字符串 "cc"，"acd"，"ac" 和 "d" 是一致字符串。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * allowed 中的字符 互不相同 。
 * words[i] 和 allowed 只包含小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-the-number-of-consistent-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: jiangjianfei
 * @create: 2022-11-08 23:07
 **/
public class T08countConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            allowedSet.add(allowed.charAt(i));
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            Boolean containsFlag = check(allowedSet, words[i]);
            if (containsFlag) {
                ans++;
            }
        }
        return ans;


    }

    private Boolean check(Set<Character> allowedSet, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!allowedSet.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public int countConsistentStrings2(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }
        int res = 0;
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            if ((mask1 | mask) == mask) {
                res++;
            }
        }
        return res;
    }
}
