package com.example.demo.t20221001;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: demoes
 * @description: 我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * 示例 2:
 * <p>
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * 示例 3:
 * <p>
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 30
 * 1 <= k <= 2n - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/k-th-symbol-in-grammar
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-10-20 22:12
 **/
public class T20kthGrammar {
    public int kthGrammar(int n, int k) {
        if (n <= 1) {
            return 0;
        }
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.offer(0);
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (!queue1.isEmpty()) {
                process(queue1, queue2);
            } else {
                process(queue2, queue1);
            }
        }
        return queue1.isEmpty() ? getAns(queue2, k) : getAns(queue1, k);

    }

    private void process(Queue<Integer> queue1, Queue<Integer> queue2) {

        while (!queue1.isEmpty()) {
            Integer temp = queue1.poll();
            if (temp == 1) {
                queue2.offer(1);
                queue2.offer(0);
            } else {
                queue2.offer(0);
                queue2.offer(1);
            }
        }
    }

    private int getAns(Queue<Integer> queue, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = queue.poll().intValue();
        }
        return ans;
    }

    public int kthGrammar2(int n, int k) {
        // return Integer.bitCount(k - 1) & 1;
        k--;
        int res = 0;
        while (k > 0) {
            k &= k - 1;
            res ^= 1;
        }
        return res;
    }
    @Test
    public void t1(){
        kthGrammar(30,
                434991989);
    }
}
