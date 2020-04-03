package com.young.offer;

/**
 * 输入两棵二叉树A和B,判断B是不是A的子结构
 */
public class Example18 {
    public static void main(String[] args) {
//        new Example18().solve();
    }

    public boolean haveSameRootNode(TreeNode nodeA, TreeNode nodeB) {
        if (nodeA == null) {
            return false;
        }
        if (nodeB == null) {
            return false;
        }
        boolean result = false;
        //根节点相同，就去看他们左右子节点是否相同
        if (nodeA.value == nodeB.value) {
            result = haveSameLeafNode(nodeA, nodeB);
        }
        //根节点不相同寻找他们的子节点是否相同
        if (!result) {
            result = haveSameRootNode(nodeA.left, nodeB);
        }
        if (!result) {
            result = haveSameRootNode(nodeA.right, nodeB);
        }
        return result;
    }

    private boolean haveSameLeafNode(TreeNode nodeA, TreeNode nodeB) {
        if (nodeB == null) {
            return true;
        }
        if (nodeA == null) {
            return false;
        }
        //这是自己思考出来的写法，比较繁琐，
//        boolean result = false;
//        if (nodeA.left.value == nodeB.left.value){
//            result = haveSameLeafNode(nodeA.left,nodeB.left);
//        }
//        if (result){
//            if (nodeA.right.value == nodeB.right.value){
//                result = haveSameLeafNode(nodeA.right,nodeB.right);
//            }
//        }
//        return result;
        //这是参考答案
        if (nodeA.value != nodeB.value) {
            return false;
        }
        return haveSameRootNode(nodeA.left, nodeB.left) && haveSameRootNode(nodeA.right, nodeB.right);
    }

}
