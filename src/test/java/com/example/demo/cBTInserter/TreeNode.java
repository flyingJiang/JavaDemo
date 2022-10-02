package com.example.demo.cBTInserter;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-07-28 23:17
 */
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
