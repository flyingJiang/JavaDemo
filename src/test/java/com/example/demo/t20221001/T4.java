package com.example.demo.t20221001;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-04 19:29
 **/
public class T4 {
    public int findKthLargest(int[] nums, int k) {
        // 构造大顶堆
        if (nums.length < 1) {
            return -1;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            heap.offer(num);
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = heap.poll();
        }
        return ans;

    }

    public int findKthLargest2(int[] nums, int k) {
        // 数据小或是基本有序使用快排、插入排序，数据量大使用归并
        // private static final int QUICKSORT_THRESHOLD = 286;
        // Use Quicksort on small arrays
        // private static final int INSERTION_SORT_THRESHOLD = 47;
        // Use insertion sort on tiny arrays
        // Merging
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 拓展
     */
    public int[] topKFrequent(int[] nums, int k) {
        //key为元素值，value为出现频率
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue
                = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        int[] res = new int[k];
        for (int num : nums) {
            // getOrDefault
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        //留下的都是出现频率最高的
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> poll = queue.poll();
            res[i] = poll.getKey();
        }
        return res;
    }

    @Test
    public void test1() {
        // 力扣347：给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
        // 输入: nums = [1,1,1,2,2,3], k = 2
        // 输出: [1,2]
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ans = topKFrequent(nums, k);
        System.out.println("end");

    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        //key为元素，value为出现频率
        HashMap<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0) + 1);
        }
        PriorityQueue<Map.Entry<String,Integer>> queue = new PriorityQueue<>(
                ((o1, o2) -> {
                    if(o1.getValue() == o2.getValue()){
                        return o2.getKey().compareTo(o1.getKey());
                    }
                    return o1.getValue() - o2.getValue();
                })
        );
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            queue.offer(entry);
            if(queue.size() > k){
                queue.poll();
            }
        }
        for(int i = 0; i < k; i++){
            res.add(queue.poll().getKey());
        }
        //   注意o2.getKey().compareTo(o1.getKey())是按字典倒序，为什么要这么做呢，是因为我们这里用到小顶堆，
        //   所以每次poll出来的都是最小频率元素，最后需要reverse一下，为了配合这个，所以我们构造优先队列的时候采用字典倒序。
        Collections.reverse(res);
        return res;
    }

    @Test
    public void test2() {
        // 力扣692：给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序排序。
        //输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
        //输出: ["i", "love"]
        //解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。注意，按字母顺序 "i" 在 "love" 之前。
        //————————————————
        //版权声明：本文为CSDN博主「李孛欢」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        //原文链接：https://blog.csdn.net/weixin_61543601/article/details/125003015

        String[] nums = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> ans = topKFrequent(nums, k);
        System.out.println("end");

    }

}

/**
 * 方法一：基于快速排序的选择方法
 */
class Solution {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
/*

作者：LeetCode-Solution
        链接：https://leetcode.cn/problems/xx4gT2/solution/shu-zu-zhong-de-di-k-da-de-shu-zi-by-lee-6doi/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

/**
 * 方法二：基于堆排序的选择方法
 */
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}