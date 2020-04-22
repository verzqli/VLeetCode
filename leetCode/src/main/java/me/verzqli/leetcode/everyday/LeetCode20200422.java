package me.verzqli.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

import me.verzqli.leetcode.TreeNode;

public class LeetCode20200422 {
    public static void main(String[] args) {
        System.out.printf(""+(2/100));
    }

    List<Integer> list = new ArrayList<>();
    int maxRightLevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return list;
        }
        searchTree(root, 1);
        return list;
    }

    private void searchTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level>maxRightLevel){
            list.add(root.val);
        }
        searchTree(root.right, level+1);
        maxRightLevel = Math.max(maxRightLevel, level);
        searchTree(root.left, level+1);
    }

}
