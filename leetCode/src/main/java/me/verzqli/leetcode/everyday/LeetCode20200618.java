package me.verzqli.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

import me.verzqli.leetcode.TreeNode;

/**
 * 1028. �����������ԭ������
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
class LeetCode20200618 {
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int curLevel = 0;
        int value = 0;
        for (int i = 0; i < S.length(); ) {
            //�����0
            curLevel=0;
            while (i < S.length() && S.charAt(i) == '-') {
                i++;
                curLevel++;
            }
            //�����0�������value��Ϊ��ʶ���λ�������֡�
            value=0;
            while (i < S.length() && S.charAt(i) != '-') {
                value = value * 10 + S.charAt(i) - '0';
                i++;

            }
            TreeNode node = new TreeNode(value);
            if (!stack.isEmpty()) {
                while (stack.size() > curLevel) {
                    stack.pollLast();
                }
                if (stack.peekLast().left == null) {
                    stack.peekLast().left = node;
                } else {
                    stack.peekLast().right = node;
                }
            }
            stack.addLast(node);
        }
        return stack.peekFirst();
    }
}
