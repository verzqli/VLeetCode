package me.verzqli.leetcode.tree;


import me.verzqli.leetcode.TreeNode;

/**
 * <pre>
 *     author: XuPei
 *     time  : 2019/6/6
 *     desc  : ����ǰ�����������������ؽ�������
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

    //ǰ�����{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn)
            return null;
        TreeNode root = new TreeNode(pre[startPre]);//һ��ʼ�����ڵ�������ĵ�һ��

        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {//�ҵ����������ڵ�
                //���������ڵ�.i��������ڵ��������
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                //i-startIn���������Ĵ�С�������󡢸����ң����������и��ڵ�����-1������������С��
                //��startPre+��������ǰ���������������ڵ���ǰ�������е�������
                //�������൱�ڲ���ǰ�����������
                //��i-1�������������ĩ�˽ڵ�������
                //�Դ˵ݹ顣ֱ��startPre+1>startPre+i-startIn
                //����startIn>i-1,����û�нڵ��ˡ�
                //�ܽ��������������������С��ǰ���ṩ���ڵ���ǰ�������е�������������ǰ���п����������
                //i-1�������������ĩ�˽ڵ��������������������ʼ�ڵ�����������ʼ����
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);//���Ƶķ����������������
                //��i-startIn���������Ĵ�С��+startPre����ǰ������Ľڵ��������+1,�������������ڵ�������i+1������������ʼ�ڵ�����
                break;
            }

        return root;
    }

}
