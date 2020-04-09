package com.young.offer;

public class Example27 {
    private TreeNode head;
    //这个节点是比当前节点小的前一个节点
    private TreeNode preNode;

    public TreeNode solve(TreeNode node) {
        if (node == null) {
            return node;
        }
        DFS(node);
        //leetcode上的题目是首尾两个节点需要再次相连，所以加这两行，不需要这个条件的话就不加这两行
        preNode.right=head;
        head.left = preNode;
        return head;
    }

    private void DFS(TreeNode node) {
        if (node == null) {
            return;
        }
        DFS(node.left);
        node.left = preNode;
        if (preNode==null){
            head=node;
        }else{
            preNode.right=node;
        }
        preNode = node;
        DFS(node.right);
    }

}
