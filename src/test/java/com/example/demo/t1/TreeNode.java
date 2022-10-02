package com.example.demo.t1;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-26 18:48
 **/
public class TreeNode {
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
