package com.young.offer;

public class Example39 {
    public static void main(String[] args) {
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? (left + 1) : (right + 1);

    }
    //判断是否是平衡二叉树
    public boolean isBalance(TreeNode root) {
        //把握不定需要问root为null是否为平衡二叉树
        if (root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int diff = Math.abs(left-right);
        if (diff>1){
            return false;
        }
        return isBalance(root.left)&&isBalance(root.right);
    }

    public int  isBalance2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalance2(root.left);
        if (left==-1){
            return -1;
        }
        int right = isBalance2(root.right);
        if (right==-1){
            return -1;
        }
        return Math.abs(left-right)<=1?Math.max(left,right)+1:-1;

    }
}
