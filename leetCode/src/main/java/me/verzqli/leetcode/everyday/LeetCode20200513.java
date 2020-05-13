package me.verzqli.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

import me.verzqli.leetcode.TreeNode;

/**
 * ����һ�������������㷵���䰴 ������� �õ��Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
 *
 * ?
 *
 * ʾ����
 * ��������[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * �������α��������
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class LeetCode20200513 {
    public static void main(String[] args) {
    }
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return result;
        }
        searchTree(root,0);
        return result;
    }

    private void searchTree(TreeNode root, int level) {
        if (level>=result.size()){
            List<Integer> list=new ArrayList<>();
            list.add(root.val);
            result.add(list);
        }else{
            result.get(level).add(root.val);
        }
        if (root.left!=null){
            searchTree(root.left,level+1);
        }
        if (root.right!=null){
            searchTree(root.right,level+1);
        }
    }

}
