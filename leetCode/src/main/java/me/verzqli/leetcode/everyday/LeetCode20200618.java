package me.verzqli.leetcode.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

import me.verzqli.leetcode.TreeNode;

/**
 * 1028. 从先序遍历还原二叉树
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class LeetCode20200618 {
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int curLevel = 0;
        int value = 0;
        for (int i = 0; i < S.length(); ) {
            //用完归0
            curLevel=0;
            while (i < S.length() && S.charAt(i) == '-') {
                i++;
                curLevel++;
            }
            //用完归0，这里的value是为了识别多位数的数字、
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
