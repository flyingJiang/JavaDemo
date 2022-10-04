package com.example.demo.t20221004;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-04 20:07
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
