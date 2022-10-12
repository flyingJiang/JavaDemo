package com.example.demo.t20221001;

import org.junit.Test;

/**
 * @program: demoes
 * @description: 801. 使序列递增的最小交换次数
 * 我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。
 * <p>
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
 * 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。
 * <p>
 * 数组 arr 严格递增 且  arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。
 * <p>
 * 注意：
 * <p>
 * 用例保证可以实现操作。
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 * 示例 2:
 * <p>
 * 输入: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
 * 输出: 1
 *  
 * <p>
 * 提示:
 * <p>
 * 2 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 2 * 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-10-10 21:10
 **/
public class T10minSwap {
    public int minSwap(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[] nums1c = new int[len];
        System.arraycopy(nums1, 0, nums1c, 0, len);
        int[] nums2c = new int[len];
        System.arraycopy(nums2, 0, nums2c, 0, len);

        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (nums1[i] <= nums1[i - 1]) {
                ans++;
            }
            if (nums2[i] <= nums2[i - 1]) {
                ans++;
            }
        }
        int ansLeft = 0;
        for (int i = 1; i < len; i++) {
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                continue;
            } else {
                if (nums1[i]>nums2[i-1]&&nums2[i]>nums1[i-1]) {
                    ansLeft++;
                    int temp = nums1[i];
                    nums1[i] = nums2[i];
                    nums2[i] = temp;
                }
            }
        }
        int ansRight = 0;
        for (int i = len - 1 - 1; i >= 0; i--) {
            if (nums1c[i] < nums1c[i + 1] && nums2c[i] < nums2c[i + 1]) {
                continue;
            } else {
                if (nums1c[i]>nums2c[i-1]&&nums2c[i]>nums1c[i-1]) {
                    ansRight++;
                    int temp = nums1c[i];
                    nums1c[i] = nums2c[i];
                    nums2c[i] = temp;
                }
            }
        }
        return Math.min(Math.min(ansRight, ansLeft), ans);

    }
    public int minSwap2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int at = a, bt = b;
            a = b = n;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1])  {
                a = Math.min(a, at);
                b = Math.min(b, bt + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                a = Math.min(a, bt);
                b = Math.min(b, at + 1);
            }
        }
        return Math.min(a, b);
    }

    @Test
    public void test1() {
        int[] nums1 = {0, 2, 5, 8, 9, 10, 12, 14, 18, 19, 20, 20, 24, 27, 28, 31, 33, 34, 36, 38};
        int[] nums2 = {1, 2, 5, 7, 8, 9, 11, 17, 15, 16, 19, 21, 28, 29, 30, 31, 33, 34, 38, 39};
        int ans = minSwap(nums1, nums2);
        System.out.println(ans);
    }
}
