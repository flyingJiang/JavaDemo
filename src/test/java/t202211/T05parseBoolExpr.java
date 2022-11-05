package t202211;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: demoes
 * @description: 1106. 解析布尔表达式
 * 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 * <p>
 * 有效的表达式需遵循以下约定：
 * <p>
 * "t"，运算结果为 True
 * "f"，运算结果为 False
 * "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 * "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 * "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "!(f)"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：expression = "|(f,t)"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：expression = "&(t,f)"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：expression = "|(&(t,f,t),!(t))"
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 20000
 * expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。
 * expression 是以上述形式给出的有效表达式，表示一个布尔值。
 * 通过次数17,963提交次数26,575
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/parsing-a-boolean-expression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-11-05 19:53
 **/
public class T05parseBoolExpr {
    private static final char char_t = 't';
    private static final char char_f = 'f';
    private static final char symbol_1 = '!';
    private static final char symbol_2 = '&';
    private static final char symbol_3 = '|';
    private static final char symbol_4 = '(';
    private static final char symbol_5 = ')';
    private static final char symbol_6 = ',';

    public boolean parseBoolExpr(String expression) {
        if (null == expression || expression.length() < 1) {
            return false;
        }
        // 转化为数组
        char[] c = expression.toCharArray();
        // 单调栈
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> symbolStack = new ArrayDeque<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == symbol_6) {
                continue;
            }
            if (c[i] == symbol_1 || c[i] == symbol_2 || c[i] == symbol_3) {
                symbolStack.push(c[i]);
                continue;
            }
            if (c[i] == symbol_5) {
                // 开始计算并将结果入栈
                calculate(stack, symbolStack);
                continue;
            }
            stack.push(c[i]);

        }
        if (!stack.isEmpty()) {
            if (char_t == stack.pop()) {
                return true;
            }
        }
        return false;

    }

    /**
     * 这里主要是 ! & | 的理解，这个文字游戏，就像产品的需求，开发理解不了
     * @param stack
     * @param symbolStack
     */
    private void calculate(Deque<Character> stack, Deque<Character> symbolStack) {
        char symbol = symbolStack.pop();
        int falseCount = 0;
        switch (symbol) {
            case symbol_1:
                falseCount = 0;
                while (!stack.isEmpty()) {
                    if (stack.peek() != symbol_4) {
                        // res = !((stack.pop() == char_t) ? true : false);
                        if (stack.pop() == char_f) {
                            falseCount++;
                        }
                    } else {
                        stack.pop();
                        break;
                    }
                }
                stack.push(falseCount == 1 ? char_t : char_f);
                break;
            case symbol_2:
                falseCount = 0;
                while (!stack.isEmpty()) {
                    if (stack.peek() != symbol_4) {
                        // res = res && ((stack.pop() == char_t) ? true : false); 这样写是不行的
                        // res = ((stack.pop() == char_t) ? true : false) && res;
                        // 遇到特殊用例是不可以的，改为统计0的个数
                        if (stack.pop() == char_f) {
                            falseCount++;
                        }
                    } else {
                        stack.pop();
                        break;
                    }
                }
                stack.push(falseCount < 1 ? char_t : char_f);
                break;
            case symbol_3:
                int trueCount = 0;
                while (!stack.isEmpty()) {
                    if (stack.peek() != symbol_4) {
                        // res = res || ((stack.pop() == char_t) ? true : false); 这样写是不行的
                        // res = ((stack.pop() == char_t) ? true : false) || res;
                        // 遇到特殊用例是不可以的，改为统计1的个数
                        if (stack.pop() == char_t) {
                            trueCount++;
                        }
                    } else {
                        stack.pop();
                        break;
                    }
                }
                stack.push(trueCount > 0 ? char_t : char_f);
                break;
            default:
        }

    }

    @Test
    public void t1() {
        // parseBoolExpr("|(f,f,f,t)");
        // parseBoolExpr("&(t,f)");
        boolean res = parseBoolExpr("!(&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))))");
        // !( & ( & (f),&(!(t),&(f),|(f)),&(!( & (f)),&(t),|(f, f, t))))
        System.out.println(res);
    }


    public boolean parseBoolExpr2(String expression) {
        Deque<Character> stack = new ArrayDeque<Character>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            } else if (c != ')') {
                stack.push(c);
            } else {
                int t = 0, f = 0;
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    if (val == 't') {
                        t++;
                    } else {
                        f++;
                    }
                }
                stack.pop();
                char op = stack.pop();
                switch (op) {
                    case '!':
                        stack.push(f == 1 ? 't' : 'f');
                        break;
                    case '&':
                        stack.push(f == 0 ? 't' : 'f');
                        break;
                    case '|':
                        stack.push(t > 0 ? 't' : 'f');
                        break;
                    default:
                }
            }
        }
        return stack.pop() == 't';
    }
}
