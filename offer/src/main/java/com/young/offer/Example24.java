package com.young.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true, 否则返回false. 假设输入的数组的任意两个数字都互不相同。
 */
public class Example24 {
    public static void main(String[] args) {
//        new Example24().solve();
    }

    public boolean solve(int[] array) {
        if (array == null || array.length < 2) {
            return true;
        }
        return searchTree(array, 0, array.length - 1);
    }

    private boolean searchTree(int[] array, int leftIndex, int rightIndex) {
        //如果循环到左右点index相同，说明就已经循环完了
        if (leftIndex >= rightIndex) {
            return true;
        }
        int rootNode = array[rightIndex];
        int k = leftIndex;
        //寻找第一个大于根节点的点，这个点就是右子树的开始点
        while (k < rightIndex && array[k] < rootNode) {
            k++;
        }
        int i = k;
        //判断k点后面的点是否都大于根节点，如果有小于的可以直接判断不是后序遍历
        while (i < rightIndex) {
            if (array[i] < rootNode) {
                return false;
            }
            i++;
        }
        //第一个是left子树是否正确，第二个是right子树是否正确，
        // k为右子树的第一个点 所以k-1是左子树的根节点，
        // rightIndex是原始树的根节点，rightIndex - 1就是右子树的根节点
        return searchTree(array, leftIndex, k - 1) && searchTree(array, k, rightIndex - 1);
    }

}
