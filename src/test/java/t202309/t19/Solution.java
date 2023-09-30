package t202309.t19;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: JavaDemo
 * @description:
 * @author: jiangjianfei
 * @create: 2023-09-19 20:22
 **/
public class Solution {
    public int minCapability(int[] nums, int k) {
        // 找出最小的k个不相邻的数据
        // 找到最小的去除左右元素，在继续找
        int size = nums.length;
        int[] numsTemp = Arrays.copyOf(nums, size);
        Arrays.sort(numsTemp);
        int n;
        for (int i = 0; i < k; i++) {
            n = numsTemp[0];
            if (i == k - 1) {
                return n;
            }
            process(numsTemp, nums, n);
        }


        return 0;
    }

    /**
     * 移除最小值的左右
     *
     * @param numsTemp
     * @param nums
     * @param n
     */
    private void process(int[] numsTemp, int[] nums, int n) {
        int min = 0;
        int max = nums.length - 1;
        for (int i = 0; i < max; i++) {
            if (nums[i] == n) {
                if (i - 1 > min) {

                }
            } else {

            }
        }
    }

    public int minCapability2(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            int count = 0;
            boolean visited = false;
            for (int x : nums) {
                if (x <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }
            if (count >= k) {
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return lower;
    }

    @Test
    public void t1() {
        int[] nums = {2, 3, 5, 9};
        int k = 2;

    }
}
