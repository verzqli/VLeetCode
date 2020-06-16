package me.verzqli.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import me.verzqli.leetcode.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 297. �����������л��뷴���л�
 * ���л��ǽ�һ�����ݽṹ���߶���ת��Ϊ�����ı���λ�Ĳ������������Խ�ת��������ݴ洢��һ���ļ������ڴ��У�ͬʱҲ����ͨ�����紫�䵽��һ���������������ȡ�෴��ʽ�ع��õ�ԭ���ݡ�
 * <p>
 * �����һ���㷨��ʵ�ֶ����������л��뷴���л������ﲻ�޶�������� / �����л��㷨ִ���߼�����ֻ��Ҫ��֤һ�����������Ա����л�Ϊһ���ַ������ҽ�����ַ��������л�Ϊԭʼ�����ṹ��
 * <p>
 * ʾ��:
 * <p>
 * ����Խ����¶�������
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * ���л�Ϊ "[1,2,3,null,null,4,5]"
 * ��ʾ: ���� LeetCode Ŀǰʹ�õķ�ʽһ�£���������� LeetCode ���л��������ĸ�ʽ���㲢�Ǳ����ȡ���ַ�ʽ����Ҳ���Բ��������ķ������������⡣
 * <p>
 * ˵��: ��Ҫʹ����ĳ�Ա / ȫ�� / ��̬�������洢״̬��������л��ͷ����л��㷨Ӧ������״̬�ġ�
 */
class LeetCode20200616 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(5);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = treeNode;
        System.out.println("result=: " + new LeetCode20200616().serialize(root));
        ;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        return dfs(root, new StringBuilder()).toString();
    }

    private StringBuilder dfs(TreeNode root, StringBuilder result) {
        if (root == null) {
            result.append("null").append(",");
            return result;
        } else {
            result.append(root.val).append(",");
            dfs(root.left, result);
            dfs(root.right, result);
        }
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] node = data.split(",");
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(node));
        return dfs2(queue);
    }

    private TreeNode dfs2(Deque<String> list) {
        TreeNode root;
        if (list.peekFirst().equals("null")) {
            list.pollFirst();
            return null;
        } else {
            root = new TreeNode(Integer.parseInt(list.peekFirst()));
            list.pollFirst();
            root.left = dfs2(list);
            root.right = dfs2(list);
        }
        return  root;
    }
}
