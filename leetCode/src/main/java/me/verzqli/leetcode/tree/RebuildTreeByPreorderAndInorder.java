package me.verzqli.leetcode.tree;


import me.verzqli.leetcode.TreeNode;

/**
 * <pre>
 *     author: XuPei
 *     time  : 2019/6/6
 *     desc  : 根据前序遍历和中序遍历来重建二叉树
 * </pre>
 */
public class RebuildTreeByPreorderAndInorder {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode node =buildTree(pre,in);
        System.out.printf(""+node);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = reConstructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);//一开始，根节点是数组的第一个

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {//找到二叉树根节点
                //左子树根节点.i是中序根节点的索引，
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                //i-startIn是左子树的大小（中序：左、根、右，所以数组中根节点索引-1就是左子树大小）
                //而startPre+它，就是前序中左子树结束节点在前序数组中的索引，
                //这样就相当于查找前序的左子树。
                //而i-1是中序的左子树末端节点索引，
                //以此递归。直到startPre+1>startPre+i-startIn
                //或者startIn>i-1,代表没有节点了。
                //总结就是中序计算出左子树大小，前序提供根节点在前序数组中的索引，这样在前序中框出来左子树
                //i-1是中序的左子树末端节点索引，中序的左子树起始节点索引就是起始索引
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);//类似的方法框出来右子树。
                //（i-startIn（左子树的大小）+startPre）（前序最左的节点的索引）+1,就是右子树根节点索引。i+1是右子树的起始节点索引
                break;
            }

        return root;
    }

}
