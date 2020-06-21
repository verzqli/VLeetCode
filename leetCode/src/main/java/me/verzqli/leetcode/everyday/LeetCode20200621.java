package me.verzqli.leetcode.everyday;

import me.verzqli.leetcode.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class LeetCode20200621 {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        searchTree(root);
        return result;
    }

    private int searchTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //返回左右节点的最大值
        int leftMax = searchTree(root.left);
        int rightMax = searchTree(root.right);
        //这里把左+root+右的节点和最大值判断，判断当前root的最大路径和
        int max = root.val;
        if (leftMax>0){
            max+=leftMax;
        }
        if (rightMax>0){
            max+=rightMax;
        }
        result=Math.max(result,max);
        //注意，这里返回去的是左右子树和的最大值和root值得和，当为负值时，则舍弃左右子树，因为没价值
        int leftRightMax = Math.max(leftMax,rightMax);
        return leftRightMax>0?leftRightMax+root.val:root.val;
    }

}
