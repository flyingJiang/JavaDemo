package com.example.demo.t20221001;

import java.util.Arrays;

/**
 * @program: demoes
 * @description: 给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
 * <p>
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 * <p>
 * arr[0], arr[1], ..., arr[i] 为第一部分；
 * arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
 * arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回 [-1, -1]。
 * <p>
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,0,1,0,1]
 * 输出：[0,3]
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,0,1,1]
 * 输出：[-1,-1]
 * 示例 3:
 * <p>
 * 输入：arr = [1,1,0,0,1]
 * 输出：[0,2]
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 3 * 104
 * arr[i] 是 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/three-equal-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-10-06 15:47
 **/
public class T6threeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        // 库函数
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }

        int partial = sum / 3;
        int first = 0, second = 0, third = 0, cur = 0;
        // [1,0,1,0,0,1,0]
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    // 0
                    first = i;
                } else if (cur == partial) {
                    // 2
                    second = i;
                } else if (cur == 2 * partial) {
                    // 5
                    third = i;
                }
                cur++;
            }
        }
        // 设 \textit{len} = \textit{arr.length} - \textit{third}len=arr.length−third，表示二进制值的长度。
        // 接下来只需要判断 [\textit{first}, \textit{first} + \textit{len})[first,first+len)、[\textit{second}, \textit{second} + \textit{len})[second,second+len) 和 [\textit{third}, \textit{third} + \textit{len})[third,third+len) 是否完全相同即可。前提是 \textit{first} + \textit{len} \le \textit{second}first+len≤second 并且 \textit{second} + \textit{len} \le \textit{third}second+len≤third。
        //如果以上三段区间是完全相同的，那么答案就是 [\textit{first} + \textit{len} - 1, \textit{second} + \textit{len}][first+len−1,second+len]。最后需要注意到，如果 \textit{sum} = 0sum=0，我们需要直接返回答案 [0, 2][0,2]

        // 7-5=2
        int len = arr.length - third;
        // 如果不满足条件一定不想等
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (third + i < arr.length) {
                // 按位判断
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            // 返回值需要思考
            return new int[]{first + len - 1, second + len};
        }
        return new int[]{-1, -1};
    }
}
