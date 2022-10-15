package com.example.demo.t20221001;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @program: demoes
 * @description: 给你一个数组 target 和一个整数 n。每次迭代，需要从  list = { 1 , 2 , 3 ..., n } 中依次读取一个数字。
 * <p>
 * 请使用下述操作来构建目标数组 target ：
 * <p>
 * "Push"：从 list 中读取一个新元素， 并将其推入数组中。
 * "Pop"：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * <p>
 * 请返回构建目标数组所用的操作序列。如果存在多个可行方案，返回任一即可。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 * 示例 2：
 * <p>
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 * 示例 3：
 * <p>
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= target.length <= 100
 * 1 <= n <= 100
 * 1 <= target[i] <= n
 * target 严格递增
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/build-an-array-with-stack-operations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-10-15 19:46
 **/
public class T13buildArray {
    private static final String push = "Push";
    private static final String pop = "Pop";

    public List<String> buildArray(int[] target, int n) {
        List<String> op = new ArrayList<>();
        // 初始化栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0, j = 0; i < n; ) {
            if (j >= target.length) {
                return op;
            }
            stack.push(i + 1);
            op.add(push);
            if (stack.peek().intValue() == target[j] && stack.size() == (j + 1)) {
                j++;
            } else {
                stack.pop();
                op.add(pop);
            }
            i++;
        }
        return op;
    }

    /**
     * 方法一：模拟
     * 思路
     *
     * 操作的对象是 11 到 nn 按顺序排列的数字，每次操作一个数字时，如果它在 \textit{target}target 中，则只需要将它 \texttt{Push}Push 入栈即可。如果不在 \textit{target}target 中，可以先将其 \texttt{Push}Push 入栈，紧接着 \texttt{Pop}Pop 出栈。因为 \textit{target}target 中数字是严格递增的，因此只要遍历 \textit{target}target，在 \textit{target}target 中每两个连续的数字 \textit{prev}prev 和 \textit{number}number 中插入 \textit{number} - \textit{prev} - 1number−prev−1 个 \texttt{Push}Push 和 \texttt{Pop}Pop，再多加一个 \texttt{Push}Push 来插入当前数字即可。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/build-an-array-with-stack-operations/solution/yong-zhan-cao-zuo-gou-jian-shu-zu-by-lee-omde/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param target
     * @param n
     * @return
     */
    public List<String> buildArray2(int[] target, int n) {
        List<String> res = new ArrayList<String>();
        int prev = 0;
        for (int number : target) {
            for (int i = 0; i < number - prev - 1; i++) {
                res.add("Push");
                res.add("Pop");
            }
            res.add("Push");
            prev = number;
        }
        return res;
    }
}
