package me.verzqli.leetcode.everyday;

import java.util.HashMap;

import me.verzqli.leetcode.TreeNode;
public class LeetCode20200522 {
    public static void main(String[] args) {
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[pStart]);
        //左子树的长度。
        int leftTreeLength = 0;
        while (inorder[iStart + leftTreeLength] != preorder[pStart]) {
            leftTreeLength++;
        }
        rootNode.left = build(preorder, inorder, pStart + 1, pStart + leftTreeLength, iStart, iStart + leftTreeLength - 1);
        rootNode.right = build(preorder, inorder, pStart + leftTreeLength + 1, pEnd, iStart + leftTreeLength + 1, iEnd);
        return rootNode;
    }
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build2(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[pStart]);
        //左子树的长度。
        int leftTreeLength = map.get(rootNode.val)-iStart;

        rootNode.left = build(preorder, inorder, pStart + 1, pStart + leftTreeLength, iStart, iStart + leftTreeLength - 1);
        rootNode.right = build(preorder, inorder, pStart + leftTreeLength + 1, pEnd, iStart + leftTreeLength + 1, iEnd);
        return rootNode;
    }

}
