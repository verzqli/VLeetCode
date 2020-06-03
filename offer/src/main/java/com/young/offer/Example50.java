package com.young.offer;

import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.tree.Tree;

class Example50 {
    public static void main(String[] args) {
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        findNode(root, p, list);
        findNode(root, q, list2);
        int length = Math.min(list.size(),list2.size());
        TreeNode result=null;
        for (int i = 0; i <length ; i++) {
            if (list.get(i)==list2.get(i)){
                result = list.get(i);
            }else{
                break;
            }
        }
        return result;
    }
    private boolean findNode(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null) {
            return false;
        }
        list.add(root);
        if (root == target) {
            return true;
        }
        if (findNode(root.left, target, list) || findNode(root.right, target, list)) {
            return true;
        } else {
            list.remove(root);
            return false;
        }
    }

}
