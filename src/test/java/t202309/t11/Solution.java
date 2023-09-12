package t202309.t11;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: JavaDemo
 * @description:
 * @author: jiangjianfei
 * @create: 2023-09-11 22:00
 **/
public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        // 优先队列中所有课程的总时间
        int total = 0;

        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (total + ti <= di) {
                total += ti;
                q.offer(ti);
            } else if (!q.isEmpty() && q.peek() > ti) {
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }

        return q.size();
    }

    @Test
    public void t1() {
        int[][] arr = {
                {100, 200},
                {200, 1300},
                {2000, 3200},
                {1000, 1250}
        };
        scheduleCourse(arr);

    }
}
