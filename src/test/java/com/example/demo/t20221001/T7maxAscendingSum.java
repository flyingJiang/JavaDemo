package com.example.demo.t20221001;

/**
 * @program: demoes
 * @description: 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * <p>
 * 子数组是数组中的一个连续数字序列。
 * <p>
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,20,30,40,50]
 * 输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 * 示例 3：
 * <p>
 * 输入：nums = [12,17,15,13,10,11,12]
 * 输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 * 示例 4：
 * <p>
 * 输入：nums = [100,10,1]
 * 输出：100
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-ascending-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: jiangjianfei
 * @create: 2022-10-07 19:25
 **/
public class T7maxAscendingSum {
    // 这个与求最长子数组
    public int maxAscendingSum(int[] nums) {
        // 找到升序子数组，计算和
        // 可以用「滚动数组」的方法来进行空间优化
        int ans = 0;
        int len = 0;
        while (len < nums.length) {
            int cur = nums[len++];
            // 连续最大
            while (len < nums.length && nums[len] > nums[len - 1]) {
                cur += nums[len++];
            }
            ans = Math.max(cur, ans);
        }
        return ans;

    }
}
