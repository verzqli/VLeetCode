package me.verzqli.leetcode.everyday;

import me.verzqli.leetcode.TreeNode;

/**
 * 124. �������е����·����
 * ����һ���ǿն����������������·���͡�
 *
 * �����У�·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣
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
        //�������ҽڵ�����ֵ
        int leftMax = searchTree(root.left);
        int rightMax = searchTree(root.right);
        //�������+root+�ҵĽڵ�����ֵ�жϣ��жϵ�ǰroot�����·����
        int max = root.val;
        if (leftMax>0){
            max+=leftMax;
        }
        if (rightMax>0){
            max+=rightMax;
        }
        result=Math.max(result,max);
        //ע�⣬���ﷵ��ȥ�������������͵����ֵ��rootֵ�úͣ���Ϊ��ֵʱ��������������������Ϊû��ֵ
        int leftRightMax = Math.max(leftMax,rightMax);
        return leftRightMax>0?leftRightMax+root.val:root.val;
    }

}
