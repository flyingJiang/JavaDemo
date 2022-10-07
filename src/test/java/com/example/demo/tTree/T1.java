package com.example.demo.tTree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: demoes
 * @description: 专门处理树，往往我们在工作中处理特殊数据时会遇到
 * @author: jiangjianfei
 * @create: 2022-10-04 20:06
 **/
public class T1 {
    private static TreeNode root;

    /**
     * 中序
     * 左根右
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
/*
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (stack.isEmpty()){
            TreeNode node = stack.pop();
            if (Instant)
        }
        return res;

    }*/

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
/*
    作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    /**
     * Morris 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }


    @Before
    public void init() {
        for (int i = 0; i < 1; i++) {
            TreeNode left = new TreeNode(i);
            TreeNode right = new TreeNode(i + 11);
            root = new TreeNode(10, left, right);
        }

    }

    @Test
    public void test1() {
        List<Integer> ans = inorderTraversal(root);
        System.out.println("end");
    }
    /*
    class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
    WHITE, GRAY = 0, 1
    res = []
    stack = [(WHITE, root)]
            while stack:
    color, node = stack.pop()
            if node is None: continue
            if color == WHITE:
            stack.append((WHITE, node.right))
            stack.append((GRAY, node))
            stack.append((WHITE, node.left))
            else:
            res.append(node.val)
            return res

    作者：hzhu212
    链接：https://leetcode.cn/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}