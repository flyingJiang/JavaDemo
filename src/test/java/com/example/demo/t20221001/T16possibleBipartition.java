package com.example.demo.t20221001;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demoes
 * @description: 886. 可能的二分法
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * <p>
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 * <p>
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/possible-bipartition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-10-16 21:32
 **/
public class T16possibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (n <= 1) {
            return false;
        }
        if (dislikes.length <= 0) {
            return true;
        }
        // 两组
//        StringBuilder g1 = new StringBuilder();
//        StringBuilder g2 = new StringBuilder();
        List<Integer> g1 = new ArrayList<>();
        List<Integer> g2 = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < dislikes.length; i++) {
            if (g1.contains(dislikes[i][0]) && !g2.contains(dislikes[i][0]) && !g1.contains(dislikes[i][1]) && g2.contains(dislikes[i][1])) {
                if (g2.contains(dislikes[i][0])) {

                }
            }
        }
        return false;

    }
}
