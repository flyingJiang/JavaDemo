package com.example.demo.tGraph;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-07 21:04
 **/
public class tGraph {
    /**
     * https://www.cnblogs.com/tianyiya/p/15823190.html
     * 490. 迷宫
     * 由空地（用 0 表示）和墙（用 1 表示）组成的迷宫 maze 中有一个球。球可以途经空地向 上、下、左、右 四个方向滚动，且在遇到墙壁前不会停止滚动。当球停下时，可以选择向下一个方向滚动。
     * 给你一个大小为 m x n 的迷宫 maze ，以及球的初始位置 start 和目的地 destination ，其中 start = [startrow, startcol] 且 destination = [destinationrow, destinationcol] 。请你判断球能否在目的地停下：如果可以，返回 true ；否则，返回 false 。
     * <p>
     * 你可以 假定迷宫的边缘都是墙壁（参考示例）。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/the-maze
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;
            for (int[] dir : dirs) {
                int x = s[0];
                int y = s[1];
                while (x + dir[0] >= 0 && y + dir[1] >= 0 && x + dir[0] < maze.length && y + dir[1] < maze[0].length && maze[x + dir[0]][y + dir[1]] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x][y]) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }

    /**
     * 示例 2:
     * 输入 1: 迷宫由以下二维数组表示
     * 0 0 1 0 0
     * 0 0 0 0 0
     * 0 0 0 1 0
     * 1 1 0 1 1
     * 0 0 0 0 0
     * 输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
     * 输入 3: 目的地坐标 (rowDest, colDest) = (3, 2)
     * 输出: false
     * 解析: 没有能够使球停在目的地的路径。
     * ————————————————
     * 版权声明：本文为CSDN博主「王培琳」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/weixin_44171872/article/details/108931956
     */
    @Test
    public void test1() {
        int[][] maze = {
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0},
        };
        int[] start = {4, 3};
        int[] destination = {0, 1};
        boolean ans = hasPath(maze, start, destination);
        System.out.println("ans = " + ans);
    }
}
