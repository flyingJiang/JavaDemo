package com.example.demo.core;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: demoes
 * @description: 记录核心方法的使用，记录jdk方法的使用
 * @author: jiangjianfei
 * @create: 2022-10-01 22:10
 **/
public class T1 {
    /**
     * Character
     */
    @Test
    public void testCharacter() {

        StringBuilder digits = new StringBuilder();

        String number = "a1b2c3,#";
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c)) {
                digits.append(c);
                System.out.println("isDigit, " + c);
            }
            if (Character.isLetter(c)) {
                System.out.println("isLetter, " + c);
            }
        }
        /**
         * @param      start    The beginning index, inclusive.
         * @param      end      The ending index, exclusive.
         */
        String s = digits.substring(0, 2);
        System.out.println("substring, " + s);

        int num = 1234567;
        char[] charArraySort = String.valueOf(num).toCharArray();


        String str1 = "12345asdf";
        char[] str1s = str1.toCharArray();

        System.out.println("end");


    }

    @Test
    public void testInteger() {
        System.out.println("MAX_VALUE, " + Integer.MAX_VALUE);
        System.out.println("MIN_VALUE, " + Integer.MIN_VALUE);
        System.out.println("end");

    }

    @Test
    public void testArrays() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] sortedArr = new int[arr.length];
        /**
         * @param      src      the source array.
         * @param      srcPos   starting position in the source array.
         * @param      dest     the destination array.
         * @param      destPos  starting position in the destination data.
         * @param      length   the number of array elements to be copied.
         */
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        // 先去除重复
        // 然后排序，获得唯一下标
        Arrays.sort(sortedArr);

        String hash = Arrays.toString(sortedArr);
        System.out.println("toString, " + hash);


        int[] ans = new int[arr.length];
        Arrays.fill(ans, Integer.MAX_VALUE);

        System.out.println("end");
    }

    @Test
    public void testMath() {
        int a = 1, b = 2, c = -3;
        Math.max(a, b);
        Math.min(a, b);
        Math.abs(c);
    }

    @Test
    public void testQueue() {
        // 先进先出 队列
        Queue<String> queue = new LinkedList<>();
//        queue.add("1");
//        queue.add("2");
        // 用这三个
        queue.offer("31");
        queue.offer("32");
        queue.peek();
        queue.poll();
        queue.offer("3");
        // 阻塞

    }

    @Test
    public void testDeque() {
        // 栈
        Deque<Integer> stack = new ArrayDeque<>();
        stack.isEmpty();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.offerFirst(4);
        // 栈顶
        int a1 = stack.peekFirst();
        System.out.println("peekFirst, " + a1);
        stack.peek();

        // 栈底
        int a2 = stack.peekLast();
        System.out.println("peekLast, " + a2);
        stack.pop();
        stack.pollFirst();
        System.out.println("end");

    }

    @Test
    public void testPriorityQueue() {
        // PriorityQueue是小顶堆，PriorityQueue出入的顺序跟优先级有关，默认是从小到大的优先级顺序。
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.isEmpty();
        priorityQueue.offer(8);
        priorityQueue.offer(4);
        priorityQueue.offer(2);
        System.out.println("priorityQueue.size(), " + priorityQueue.size());
        while (!priorityQueue.isEmpty()) {
            int a = priorityQueue.poll();
            System.out.println("priorityQueue poll, " + a);

        }

        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>((o1, o2) -> o2 - o1);
        priorityQueueMax.isEmpty();
        priorityQueueMax.offer(8);
        priorityQueueMax.offer(4);
        priorityQueueMax.offer(2);
        while (!priorityQueueMax.isEmpty()) {
            int a = priorityQueueMax.poll();
            System.out.println("priorityQueueMax poll, " + a);

        }
        System.out.println("end");


    }


}
