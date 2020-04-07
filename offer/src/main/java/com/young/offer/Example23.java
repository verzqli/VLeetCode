package com.young.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 * <p>
 * 这题其实也叫二叉树的层序遍历，leetcode-102，输出的格式也就按照leetcode的输出格式来。
 * <p>
            3
           / \
        9     20
      /  \   /  \
    15   7 18	23

 上图输出的格式为

 [
 [3],
 [9,20],
 [15,7，18,23]
 ]
 */
public class Example23 {
    List<List<Integer>> rootList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return rootList;
        }
        solve(root, 0);
        return rootList;
    }

    public void solve(TreeNode node, int level) {
        List<Integer> leafList = new ArrayList<>();
        if (rootList.size() <= level) {
            leafList = new ArrayList<>();
            rootList.add(leafList);
        }
        rootList.get(level).add(node.value);
        if (node.left != null) {
            solve(node.left, level + 1);
        }
        if (node.right != null) {
            solve(node.right, level + 1);
        }

    }
}
