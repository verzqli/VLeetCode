package me.verzqli.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

import me.verzqli.leetcode.TreeNode;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * ?
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode20200513 {
    public static void main(String[] args) {
    }
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return result;
        }
        searchTree(root,0);
        return result;
    }

    private void searchTree(TreeNode root, int level) {
        if (level>=result.size()){
            List<Integer> list=new ArrayList<>();
            list.add(root.val);
            result.add(list);
        }else{
            result.get(level).add(root.val);
        }
        if (root.left!=null){
            searchTree(root.left,level+1);
        }
        if (root.right!=null){
            searchTree(root.right,level+1);
        }
    }

}
