package com.example.demo.t20221001;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-01 22:07
 **/
public class T1 {
    public String reformatNumber(String number) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < number.length(); ++i) {
            char ch = number.charAt(i);
            if (Character.isDigit(ch)) {
                digits.append(ch);
            }
        }

        int n = digits.length();
        int pt = 0;
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            if (n > 4) {
                ans.append(digits.substring(pt, pt + 3) + "-");
                pt += 3;
                n -= 3;
            } else {
                if (n == 4) {
                    ans.append(digits.substring(pt, pt + 2) + "-" + digits.substring(pt + 2, pt + 4));
                } else {
                    ans.append(digits.substring(pt, pt + n));
                }
                break;
            }
        }
        return ans.toString();
    }
    public String reformatNumber2(String number) {
        number = number.replace(" ","");
        number = number.replace("-","");
        number = number.replaceAll("(?<=\\G\\d{3})(?!$)", "-");
        number = number.replaceAll("\\b(\\d{2})(\\d+)-(\\d)$", "$1-$2$3");
        return number;
    }
/*
    作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/reformat-phone-number/solution/zhong-xin-ge-shi-hua-dian-hua-hao-ma-by-nf6g3/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
