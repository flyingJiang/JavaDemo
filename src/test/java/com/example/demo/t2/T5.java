package com.example.demo.t2;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-27 19:43
 **/
public class T5 {
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();


    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node,
                node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node,
                Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0))
                        + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode.cn/problems/house-robber-iii/solution/da-jia-jie-she-iii-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}