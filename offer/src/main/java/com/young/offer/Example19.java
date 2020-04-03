package com.young.offer;

/**
 * 给定一个二叉树A，输出它的镜像B
 */
public class Example19 {
    public static void main(String[] args) {
//        new Example19().solve();
    }

    public void solve(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        //判断一个节点的左右节点有一个不为null就左右互换，然后递归调用
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null) {
            solve(node.left);
        }
        if (node.right != null) {
            solve(node.right);
        }
    }

}
