package t202211;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: demoes
 * @description: 1704. 判断字符串的两半是否相似
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * <p>
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * <p>
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 * 示例 2：
 * <p>
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 1000
 * s.length 是偶数
 * s 由 大写和小写 字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/determine-if-string-halves-are-alike
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-11-11 23:06
 **/
public class T11halvesAreAlike {

    public boolean halvesAreAlike(String s) {
        int len = s.length();
        String s1 = s.substring(0, len / 2);
        String s2 = s.substring(len / 2, len);
        Set<Character> ref = new HashSet<Character>();
        ref.add('a');
        ref.add('e');
        ref.add('i');
        ref.add('o');
        ref.add('u');
        ref.add('A');
        ref.add('E');
        ref.add('I');
        ref.add('O');
        ref.add('U');
        int n1 = 0, n2 = 0;
        for (int i = 0; i < len / 2; i++) {
            if (ref.contains(s1.charAt(i))) {
                n1++;
            }
            if (ref.contains(s2.charAt(i))) {
                n2++;
            }
        }
        if (n1 == n2) {
            return true;
        } else {
            return false;
        }

    }

    public boolean halvesAreAlike2(String s) {
        String a = s.substring(0, s.length() / 2);
        String b = s.substring(s.length() / 2);
        String h = "aeiouAEIOU";
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < a.length(); i++) {
            if (h.indexOf(a.charAt(i)) >= 0) {
                sum1++;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (h.indexOf(b.charAt(i)) >= 0) {
                sum2++;
            }
        }
        return sum1 == sum2;
    }
}
