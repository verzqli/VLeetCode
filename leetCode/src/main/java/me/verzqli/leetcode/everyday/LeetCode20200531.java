package me.verzqli.leetcode.everyday;

import me.verzqli.leetcode.TreeNode;

/**
 * @author verzqli
 * @date 2020/5/31
 * @Desc
 */
class LeetCode20200531 {
    public static void main(String[] args) {

    }

    int maxLevel = -1;

    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
       return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        return left.val==right.val&&check(left.left,right.right)&&check(left.right,right.left);
    }

}
