package com.example.demo.t1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-26 21:11
 **/
public class T6 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Deque<Integer> stack = new ArrayDeque<>();
            int[] res = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peekFirst()] < nums[i]) {
                    int index = stack.pop();
                    res[index] = nums[i];
                }
                stack.push(i);
            }                               //上述方式遍历后若该值右侧无大于它的值，则会保留在栈中，不会弹出
            while (!stack.isEmpty()) {     //经过上面for循环的处理，除栈中剩余值外，其余值都已处理完毕。----称为'清算阶段'
                boolean flag = false;      //用于判断遍历一边后是否能找到。
                int index = stack.pop();   //弹出栈顶得到未处理值的索引。
                for (int i = 0; i < nums.length; i++) {     //再遍历一边数组
                    if (nums[i] > nums[index]) {
                        flag = true;            //找到第一个大于弹出的值，找到赋值后直接break;
                        res[index] = nums[i];
                        break;
                    }
                }
                if (flag == false) {     //未找到设为-1.
                    res[index] = -1;
                }
            }
            return res;
        }
    }
}
